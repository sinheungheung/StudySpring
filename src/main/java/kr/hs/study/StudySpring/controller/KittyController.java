package kr.hs.study.StudySpring.controller;


import kr.hs.study.StudySpring.domain.Kitty;
import kr.hs.study.StudySpring.order.KittyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kittyList")
public class KittyController {
    private final KittyService kittyService;

    // 목록
    @GetMapping("")
    public ResponseEntity<?> getKitty() {
        List<Kitty> kitty = kittyService.getKitty();

        Kitty kitty1 = new Kitty();

        return ResponseEntity.ok(kitty);

    }

    // 상세
    @GetMapping("/{id}")
    public ResponseEntity<?> getKitty(@PathVariable(name = "id") Long id) {
        Kitty kitty = kittyService.getKitty(id);
        return ResponseEntity.ok(kitty);
    }

    // 추가
    @PostMapping("")
    public ResponseEntity<?> insertKitty(@RequestBody Kitty params) {
        kittyService.insertKitty(params.getId(), params.getName(), params.getColor());

        return ResponseEntity.ok(null);
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateKitty(@PathVariable(name = "id") Long id, @RequestBody Kitty kitty) {
        kittyService.updateKitty(id, kitty.getName(), kitty.getColor());
        return ResponseEntity.ok(null);

    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteKitty(@PathVariable(name = "id") Long id) {
        kittyService.deleteKitty(id);

        return ResponseEntity.ok(null);
    }

}
