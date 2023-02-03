package br.com.petservice.infra.resource.exceptions;

import java.io.Serializable;
import java.time.Instant;

public record StandardError(Instant timestamp, Integer status, String error, String message, String path) implements Serializable {

}
