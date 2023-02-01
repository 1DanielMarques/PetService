package br.com.petservice.model.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

public record StandardError(Instant timestamp, Integer status, String error, String message, String path) implements Serializable {

}
