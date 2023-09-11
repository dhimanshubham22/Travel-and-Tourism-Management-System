// Function to validate the form fields before submission
    function validateForm() {
        var fromInput = document.getElementById("from");
        var dateInput = document.getElementById("filterDate");
        var busNameInput = document.getElementById("busName");
        var toInput = document.getElementById("to");
        var priceInput = document.getElementById("price");
        var timeInput = document.getElementById("time");

        if (
            fromInput.value.trim() === "" ||
            dateInput.value.trim() === "" ||
            busNameInput.value.trim() === "" ||
            toInput.value.trim() === "" ||
            priceInput.value.trim() === "" ||
            timeInput.value.trim() === ""
        ) {
            alert("Please fill in all fields.");
            return false; // Prevent form submission
        }
        
        return true; // Allow form submission
    }

    // Get the date input element
    var dateInput = document.getElementById("filterDate");

    // Get the current date
    var currentDate = new Date();

    // Set the minimum date to today
    dateInput.min = currentDate.toISOString().split('T')[0];