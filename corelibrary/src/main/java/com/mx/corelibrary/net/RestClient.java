package com.mx.corelibrary.net;

import com.mx.corelibrary.net.callback.IError;
import com.mx.corelibrary.net.callback.IFailure;
import com.mx.corelibrary.net.callback.IRequest;
import com.mx.corelibrary.net.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.RequestBody;

public class RestClient {

    private final WeakHashMap<String, Object> PARAMS;
    private final String URL;
    private final IRequest REQUEST;
//    private final String DOWNLOAD_DIR;
//    private final String EXTENSION;
//    private final String NAME;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;


//    private final LoaderStyle LOADER_STYLE;
//    private final File FILE;
//    private final Context CONTEXT;

    public RestClient(WeakHashMap<String, Object> params,
                      String url,
                      IRequest request,
                      ISuccess success,
                      IFailure failure,
                      IError error,
                      RequestBody body) {
        PARAMS = params;
        URL = url;
        REQUEST = request;
        SUCCESS = success;
        FAILURE = failure;
        ERROR = error;
        BODY = body;
    }

    public static RestClientBuilder builder(){
        return new RestClientBuilder();
    }

}
