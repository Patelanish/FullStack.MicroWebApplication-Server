package zipcode.group3.showboat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zipcode.group3.showboat.model.Video;
import zipcode.group3.showboat.repository.VideoRepository;

import java.util.List;

@Service
public class VideoService {

    private VideoRepository repository;

    @Autowired
    public VideoService(VideoRepository repository) {
        this.repository = repository;
    }

    public Video create(Video video) {
        return repository.save(video);
    }

    public Video read(Long id) {
        return repository.findById(id).get();
    }
    public List<Video> readAll() {
        return repository.findAll();
    }

    public Video update(Long id, Video updatedVideo) {
        Video video = read(id);
        video.setName(updatedVideo.getName());
        video.setFilepath(updatedVideo.getFilepath());
        video.setDatecreated(updatedVideo.getDatecreated());
        video.setDescription(updatedVideo.getDescription());
        return repository.save(video);
    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
