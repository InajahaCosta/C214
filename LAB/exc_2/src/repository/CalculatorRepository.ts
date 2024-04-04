import { Person } from "../models/Calc" 


type Response = {
    success: unknown,
    error: unknown
}

export interface CalculatorRepository {
    calculateIMC (person: Person): Response
}