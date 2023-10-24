package kr.hs.study.StudySpring.controller;

import kr.hs.study.StudySpring.domain.IceCream;
import kr.hs.study.StudySpring.service.IceCreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/iceCreams")
@RestController
public class IceCreamController {
    private final IceCreamService iceCreamService;

    @GetMapping("")
    public ResponseEntity<?> getIceCream() {
        List<IceCream> iceCreams = iceCreamService.getIceCreams();

        return ResponseEntity.ok(iceCreams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIceCream(@PathVariable(name = "id") Long id) {
        String iceCream = iceCreamService.getIceCream(id);

        return ResponseEntity.ok(iceCream);

    }

    @PostMapping("")
    public ResponseEntity<?> insertIceCream(@RequestBody IceCream iceCream) {
        String insert = iceCreamService.insertIceCream(iceCream.getName(), iceCream.getFlavor());

        return ResponseEntity.ok(insert);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateIceCream(@PathVariable(name = "id") Long id, @RequestBody IceCream iceCream) {
        String update = iceCreamService.updateIceCream(id, iceCream.getName(), iceCream.getFlavor());

        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIceCream(@PathVariable(name = "id") Long id) {
        String delete = iceCreamService.deleteIceCream(id);

        return ResponseEntity.ok(delete);
    }
}
