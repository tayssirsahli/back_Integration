package com.tayssir.user.service;

import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tayssir.user.entity.Image;
import com.tayssir.user.repository.ImageRepository;
import com.tayssir.user.repository.UserRepository;

@Service
public class ImageServiceImpl implements ImageService {
	@Autowired
	ImageRepository imageRepository;

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@Override
	public Image uplaodImage(MultipartFile file) throws IOException {
		Image image = new Image(file.getOriginalFilename(), file.getContentType(), file.getBytes(), null);
		return imageRepository.save(image);
	}

	@Override
	public Image getImageDetails(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		Image image = dbImage.orElseThrow(() -> new IOException("Image not found"));
		return new Image(image.getIdImage(), image.getName(), image.getType(), image.getImage(), image.getMedecin());
	}

	@Override
	public ResponseEntity<byte[]> getImage(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType()))
				.body(dbImage.get().getImage());
	}

	@Override
	public void deleteImage(Long id) {
		imageRepository.deleteById(id);
	}

	

}
