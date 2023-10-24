package kr.hs.study.StudySpring.controller;

import kr.hs.study.StudySpring.domain.Me;
import kr.hs.study.StudySpring.service.MeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/meList")
@RestController
public class MeController {
    private final MeService meService;

    @GetMapping("")
    public ResponseEntity<?> getMe() {
        List<Me> getMeList = meService.getMeList();
        return ResponseEntity.ok(getMeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMe(@PathVariable(name = "id") Long id) {
        String me = meService.getMe(id);
        return ResponseEntity.ok(me);
    }

    @PostMapping("")
    public ResponseEntity<?> insertMe(@RequestBody Me me) {
        String insertMe = meService.insertMe(me.getName(), me.getAge());
        return ResponseEntity.ok(insertMe);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateMe(@PathVariable(name = "id") Long id, @RequestBody Me me) {
        String updateMe = meService.updateMe(id, me.getName(), me.getAge());
        return ResponseEntity.ok(updateMe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMe(@PathVariable(name = "id") Long id) {
        String deleteMe = meService.deleteMe(id);

        return ResponseEntity.ok(deleteMe);
    }
}
