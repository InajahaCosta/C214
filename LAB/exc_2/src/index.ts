import readline from 'readline'
import { promisify } from 'util'
import { Person } from './models/Calc' 
import { Calculator } from './services/Calculator'

const reader = readline.createInterface({
  input: process.stdin,
  output: process.stdout
})

const userInput = promisify(reader.question).bind(reader)

async function getUserInput (prompt: string): Promise<any> {
  return await userInput(prompt)
}

const calc = new Calculator()

async function calculateIMC () {
    const personData: Person = {
        weight: 0,
        height: 0
    }

    personData.weight = parseFloat(await getUserInput('Enter the weight in kg: '))
    personData.height = parseFloat(await getUserInput('Enter the height in meters: '))

    console.log('Your IMC is: ', calc.calculateIMC(personData))
}

async function startCalculator () {
  await calculateIMC()
  reader.close()
}

startCalculator()