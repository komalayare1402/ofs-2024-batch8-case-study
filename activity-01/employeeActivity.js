import { Employee } from "./employee.js";
import fs from "fs";

const employee1 = new Employee(12, "Komss", 46200);
const employee2 = new Employee(13, "Biks", 412200);
const employee3 = new Employee(14, "Mits", 47781);
const employee4 = new Employee(15, "Tejas", 65363);

employee1.display();

const filePath = 'employees.json';

let data = [];

try {
    if (fs.existsSync(filePath)) {
        const rawData = fs.readFileSync(filePath, 'utf8');
        data = JSON.parse(rawData);

        if (!Array.isArray(data)) {
            console.warn('Warning: The data read from the file is not an array. Resetting to an empty array.');
            data = [];
        } else {
            console.log('Current data:', data);
        }
    }
} catch (error) {
    console.error('Error reading file:', error.message);
    data = []; 
}

data.push({
    employee4
});

fs.writeFile(filePath, JSON.stringify(data, null, 2), 'utf8', (error) => {
    if (error) {
        console.error('Error writing file:', error.message);
    } else {
        console.log('File successfully updated!');
    }
});

try {
    const updatedRawData = fs.readFileSync(filePath, 'utf8');
    const updatedData = JSON.parse(updatedRawData);
    console.log('Updated data:', updatedData);
} catch (error) {
    console.error('Error reading updated file:', error.message);
}
