import { Person } from "../services/Calculator";
import { CalculatorRepository } from "../repository/CalculatorRepository";

export class CalculatorAdapter implements CalculatorRepository {
    
    result: number;

    constructor() {
        this.result = 0;
    }

    calculateIMC(person: Person) {
        try {
          this.result = person.weight / (person.height * person.height);
          return {
            success: this.result,
            error: null
          };
        } catch (error) {
          return {
            success: null,
            error: 'Cannot calculate IMC'
          };
        }
      }   
}