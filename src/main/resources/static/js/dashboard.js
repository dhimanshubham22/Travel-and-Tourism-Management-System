    // Get the date input element
    var dateInput = document.getElementById("filterDate");

    // Get the current date
    var currentDate = new Date();

    // Set the minimum date to today
    dateInput.min = currentDate.toISOString().split('T')[0];