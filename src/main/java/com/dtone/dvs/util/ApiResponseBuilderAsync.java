package com.dtone.dvs.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.dtone.dvs.dto.ApiError;
import com.dtone.dvs.dto.ApiResponse;
import com.dtone.dvs.dto.ErrorResponse;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class ApiResponseBuilderAsync {

	private static ObjectMapper objectMapper;

	/**
	 * Prepare API response
	 * 
	 * @param <T>         the result type
	 * @param apiResponse the api response object
	 * @param typeReference   the response type
	 * @param future    the future http response
	 * @return the final api response
	 */
	public <T> CompletableFuture<ApiResponse<T>> prepareResponse(ApiResponse<T> apiResponse, TypeReference<T> typeReference,
				CompletableFuture<HttpResponse<InputStream>> future) {
		return future.thenCompose(response -> {
			int statusCode = response.statusCode();
			setPageDetails(apiResponse, response.headers());

			apiResponse.setCode(statusCode);
			apiResponse.setSuccess(true);

			if (statusCode < 400) {
				apiResponse.setResult(extractResult(response.body(), typeReference));
			} else {
				apiResponse.setSuccess(false);
				try {
					if (response.body().available() != 0) {
						apiResponse.setErrors(extractResult(response.body(), new TypeReference<ErrorResponse>() {
						}).getErrors());
					} else {
            apiResponse.getErrors().add(new ApiError(String.valueOf(statusCode),
              getReasonPhrase(statusCode)));
					}
				} catch (IOException e) {
          apiResponse.getErrors().add(new ApiError(String.valueOf(statusCode),
            getReasonPhrase(statusCode)));
				} finally {
					try {
						response.body().close();
					} catch (Exception ignored) { }
				}

			}
			return CompletableFuture.completedFuture(apiResponse);
		});
	}

	private static <T> void setPageDetails(ApiResponse<T> apiResponse, HttpHeaders headers) {
		for (Map.Entry<String, List<String>> header : headers.map().entrySet()) {
			switch (header.getKey()) {
				case Constants.CURRENT_PAGE_HEADER ->
						apiResponse.setCurrentPage(Integer.parseInt(header.getValue().stream().findFirst().orElse(HttpConstants.UNDEFINED_HEADER)));
				case Constants.RECORDS_PER_PAGE_HEADER ->
						apiResponse.setRecordsPerPage(Integer.parseInt(header.getValue().stream().findFirst().orElse(HttpConstants.UNDEFINED_HEADER)));
				case Constants.TOTAL_RECORDS_HEADER ->
						apiResponse.setTotalRecords(Integer.parseInt(header.getValue().stream().findFirst().orElse(HttpConstants.UNDEFINED_HEADER)));
				case Constants.TOTAL_PAGES_HEADER ->
						apiResponse.setTotalPages(Integer.parseInt(header.getValue().stream().findFirst().orElse(HttpConstants.UNDEFINED_HEADER)));
				case Constants.NEXT_PAGE_HEADER ->
						apiResponse.setNextPage(Integer.parseInt(header.getValue().stream().findFirst().orElse(HttpConstants.UNDEFINED_HEADER)));
				case Constants.PREVIOUS_PAGE_HEADER ->
						apiResponse.setPreviousPage(Integer.parseInt(header.getValue().stream().findFirst().orElse(HttpConstants.UNDEFINED_HEADER)));
				default -> {}
		}
		}
	}

	/**
	 * Method to extract the response object from HTTP response
	 * 
	 * @param <T>          the result type
	 * @param src   			 the InputStream source
	 * @param valueTypeRef the result type reference
	 * @return the result
	 */
	@SneakyThrows
	public static <T> T extractResult(InputStream src, TypeReference<T> valueTypeRef) {
		return getObjectMapper().readerFor(valueTypeRef).readValue(src);
	}

	/**
	 * Method to get new ObjcetMapper object
	 * 
	 * @return objectMapper
	 */
	public static ObjectMapper getObjectMapper() {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			objectMapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
			objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		}
		return objectMapper;
	}

	public static String getReasonPhrase(int statusCode) {
		return switch (statusCode) {
			case (200) -> "OK";
			case (201) -> "Created";
			case (202) -> "Accepted";
			case (203) -> "Non Authoritative Information";
			case (204) -> "No Content";
			case (205) -> "Reset Content";
			case (206) -> "Partial Content";
			case (207) -> "Partial Update OK";
			case (300) -> "Mutliple Choices";
			case (301) -> "Moved Permanently";
			case (302) -> "Moved Temporarily";
			case (303) -> "See Other";
			case (304) -> "Not Modified";
			case (305) -> "Use Proxy";
			case (307) -> "Temporary Redirect";
			case (400) -> "Bad Request";
			case (401) -> "Unauthorized";
			case (402) -> "Payment Required";
			case (403) -> "Forbidden";
			case (404) -> "Not Found";
			case (405) -> "Method Not Allowed";
			case (406) -> "Not Acceptable";
			case (407) -> "Proxy Authentication Required";
			case (408) -> "Request Timeout";
			case (409) -> "Conflict";
			case (410) -> "Gone";
			case (411) -> "Length Required";
			case (412) -> "Precondition Failed";
			case (413) -> "Request Entity Too Large";
			case (414) -> "Request-URI Too Long";
			case (415) -> "Unsupported Media Type";
			case (416) -> "Requested Range Not Satisfiable";
			case (417) -> "Expectation Failed";
			case (418) -> "Reauthentication Required";
			case (419) -> "Proxy Reauthentication Required";
			case (422) -> "Unprocessable Entity";
			case (423) -> "Locked";
			case (424) -> "Failed Dependency";
			case (500) -> "Server Error";
			case (501) -> "Not Implemented";
			case (502) -> "Bad Gateway";
			case (503) -> "Service Unavailable";
			case (504) -> "Gateway Timeout";
			case (505) -> "HTTP Version Not Supported";
			case (507) -> "Insufficient Storage";
			default -> "";
		};
	}
}
