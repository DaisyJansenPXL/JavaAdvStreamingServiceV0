package be.pxl.ja.streamingservice.model;

public interface Service<T,U> {

    T execute(U arg);
}
