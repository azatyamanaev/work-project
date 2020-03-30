package ru.itis.models;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder()
public class FileInfo {
    private Long id;
    private String storageFileName;
    private String originalFileName;
    private Long size;
    private String type;
    private String url;
}
