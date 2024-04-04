import { CalculatorAdapter } from "../adapters/CalculatorAdapter";
import { Person } from "../models/Calc";
import { CalculatorRepository } from "../repository/CalculatorRepository";
import { CalculatorInt } from "./interface/Calculator"; 

export class Calculator implements CalculatorInt{
    private calculatorAdapter: CalculatorRepository
    constructor(calculatorRepository : CalculatorRepository){
        this.calculatorAdapter = calculatorRepository
    }

    calculateIMC(person: Person): number | Error {
        try {
          return person.weight / (person.height * person.height);
        } catch (error) {
          return new Error(JSON.stringify(error))
        }
      }
}