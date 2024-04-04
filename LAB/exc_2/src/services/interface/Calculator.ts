import { Person } from "../../models/Calc";

export interface CalculatorInt {
    calculateIMC: (person: Person) => number | Error
}