package com.example.st03.service;

import com.example.st03.domain.CottonCandy;
import com.example.st03.domain.Flower;

public interface CottonCandyService {
   CottonCandy getCottonCandyByFlavor(String flavor);

   void insertCandy(String flavor, int price);
}
