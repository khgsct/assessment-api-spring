package com.gosoft.assessmentapi.file;

import java.util.UUID;

public record FileResponse (UUID id, String base64) {
}
