import { Calculator } from './Calculator';
import { CalculatorRepository } from '../repository/CalculatorRepository';
import { Person } from "../models/Calc";
import test, { describe } from 'node:test';

const makeRepositoryStub = (): CalculatorRepository => {
  class CalculatorStub implements CalculatorRepository {
    calculateIMC (person : Person) {
      return {
        success: true,
        error: null
      }
    }
  }
  return new CalculatorStub()
}

describe('Calculator', () => {
  let calculator: Calculator;

  test('Successfully calculate IMC', () => {
    const repositoryStub = makeRepositoryStub()
    const calculatorInstance = new Calculator(repositoryStub)
    expect(calculatorInstance.calculateIMC({ weight: 68, height: 1.75 })).toBeCloseTo(22.2);
  });
});

function expect(arg0: number | Error) {
  throw new Error('Function not implemented.');
}
