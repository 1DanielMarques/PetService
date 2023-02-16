package br.com.petservice.infra.resource.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.Instant;

public record StandardError(@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT-3") Instant timestamp, Integer status,
                            String error, String message,
                            String path) implements Serializable {

}
