package br.com.zup.pedro.casadocodigo.response;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -7977666825017001819L;
    private final T data;

    public BaseResponse(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
