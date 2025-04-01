package com.example.postgresdemo.controller;

import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.Operatore;
import com.example.postgresdemo.repository.OperatoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller REST per la gestione degli operatori.
 * Espone endpoint per recuperare, aggiungere, aggiornare ed eliminare operatori.
 */
@RestController
@RequestMapping("/operatori")
public class OperatoreController {

    @Autowired
    private OperatoreRepository operatoreRepository;

    /**
     * Recupera tutti gli operatori in modo paginato.
     *
     * @param pageable Oggetto che specifica la paginazione e l'ordinamento.
     * @return Una pagina contenente gli operatori.
     */
    @GetMapping
    public Page<Operatore> getOperatori(Pageable pageable) {
        return operatoreRepository.findAll(pageable);
    }

    /**
     * Recupera un operatore in base al suo ID.
     *
     * @param id ID dell'operatore da recuperare.
     * @return L'operatore richiesto.
     * @throws ResourceNotFoundException Se l'operatore non viene trovato.
     */
    @GetMapping("/{id}")
    public Operatore getOperatoreById(@PathVariable Integer id) {
        return operatoreRepository.findOperatoreByIdOperatore(id)
                .orElseThrow(() -> new ResourceNotFoundException("Operatore not found with id " + id));
    }

    /**
     * Ricerca operatori per nome.
     *
     * @param nome Nome dell'operatore da cercare.
     * @return Una lista di operatori che corrispondono al nome specificato.
     */
    @GetMapping("/search")
    public ResponseEntity<List<Operatore>> findOperatoriByNome(@RequestParam String nome) {
        List<Operatore> operatori = operatoreRepository.findOperatoreByNome(nome);
        if (operatori.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(operatori);
    }

    /**
     * Crea un nuovo operatore.
     *
     * @param operatore L'oggetto Operatore da salvare.
     * @return L'oggetto Operatore salvato.
     */
    @PostMapping
    public Operatore createOperatore(@Valid @RequestBody Operatore operatore) {
        return operatoreRepository.save(operatore);
    }

    /**
     * Aggiorna un operatore esistente.
     *
     * @param id               L'ID dell'operatore da aggiornare.
     * @param operatoreRequest L'oggetto Operatore con i nuovi dati.
     * @return L'oggetto Operatore aggiornato.
     * @throws ResourceNotFoundException Se l'operatore non viene trovato.
     */
    @PutMapping("up/{id}")
    public Operatore updateOperatore(@PathVariable Integer id,
                                     @Valid @RequestBody Operatore operatoreRequest) {
        return operatoreRepository.findById(Long.valueOf(id))
                .map(operatore -> {
                    operatore.setNome(operatoreRequest.getNome());
                    operatore.setEmail(operatoreRequest.getEmail());
                    operatore.setPassword(operatoreRequest.getPassword());
                    return operatoreRepository.save(operatore);
                }).orElseThrow(() -> new ResourceNotFoundException("Operatore not found with id " + id));
    }

    /**
     * Elimina un operatore esistente.
     *
     * @param id L'ID dell'operatore da eliminare.
     * @return ResponseEntity con stato OK se l'eliminazione avviene con successo.
     * @throws ResourceNotFoundException Se l'operatore non viene trovato.
     */
    @DeleteMapping("del/{id}")
    public ResponseEntity<?> deleteOperatore(@PathVariable Integer id) {
        return operatoreRepository.findById(Long.valueOf(id))
                .map(operatore -> {
                    operatoreRepository.delete(operatore);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Operatore not found with id " + id));
    }
}
