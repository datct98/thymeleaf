package com.example.exception.controller;

import com.example.exception.model.Wallet;
import com.example.exception.model.response.DataResponse;
import com.example.exception.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class WalletController {
    @Autowired
    WalletRepository walletRepository;

    @GetMapping(value = "/wallet/all")
    public String displayWallets(Model model){
        List<Wallet> wallets = walletRepository.findAll();
        model.addAttribute("wallets",wallets);
        return "wallet";
    }

    @DeleteMapping(value = "/deleteWallet/{id}")
    public ResponseEntity<DataResponse> deleteWallet(@PathVariable int id){
        Wallet wallet = walletRepository.findById(id).orElse(null);
        if(wallet== null){
            return ResponseEntity.ok(new DataResponse(HttpStatus.NOT_FOUND,"Not found id: "+id));
        }
        walletRepository.delete(wallet);
        return ResponseEntity.ok(new DataResponse(HttpStatus.OK, "Delete successfully "));
    }
}
