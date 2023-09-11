function updateFiled() {
    var price = document.getElementById("price").value;
    var totalpassenger = document.getElementById("noOfPersons").value;
    var totalValue = price * totalpassenger;

    document.getElementById("totalCalculated").value = totalValue;
}

function validateForm() {
    var noOfPersons = document.getElementById("noOfPersons").value;

    // Check if noOfPersons is less than or equal to 0
    if (parseInt(noOfPersons) <= 0) {
        // Display the error message near the field
        document.getElementById("noOfPersonsError").textContent = "Invaild no of Persons.";
        return false; // Prevent form submission
    } else {
        // Clear the error message if the value is valid
        document.getElementById("noOfPersonsError").textContent = "";
    }

    // If the validation passes, the form will be submitted
    return true;
}