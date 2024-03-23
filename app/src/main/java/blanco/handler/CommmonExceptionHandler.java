package blanco.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import blanco.controller.api.dto.common.ApiError;
import blanco.controller.api.dto.common.ApiErrorResponse;

@RestControllerAdvice
public class CommmonExceptionHandler extends ResponseEntityExceptionHandler {
    
    
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleResponseStatus(Exception ex, WebRequest request) {
        ApiErrorResponse res = new ApiErrorResponse();
        ApiError apiError = new ApiError();
        apiError.setStatus(405);
        apiError.setCode("XXXXXX");
        apiError.setMessage("Esto es un erorr");
        res.setApiErrorInfo(apiError);

        return handleExceptionInternal(ex, null , new HttpHeaders(), HttpStatusCode.valueOf(405), request);
    }

}
