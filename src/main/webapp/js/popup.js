function openPopup() {
    document.getElementById('popup').style.display = 'flex';
}

function openPopup2() {
    document.getElementById('popup2').style.display = 'flex';
}


   function showRegisterPopup() {
        document.getElementById("popup").style.display = "block"; // Hide Sign In popup
        document.getElementById("popup2").style.display = "none"; // Show Sign Up popup
    }


   function showRegisterPopup2() {
        document.getElementById("popup").style.display = "none"; // Hide Sign In popup
        document.getElementById("popup2").style.display = "block"; // Show Sign Up popup
    }


// Function to close the pop-up
function closePopup() {
    document.getElementById('popup').style.display = 'none';
    document.getElementById("popup2").style.display = "none"; 
}

        // Función para mostrar el popup
        function showErrorPopup() {
            document.getElementById("popup2").style.display = "block";
        }

        // Verificar si existe el parámetro 'loginError' en la URL
        window.onload = function() {
            var params = new URLSearchParams(window.location.search);
            if (params.get('loginError') === 'true') {
                showErrorPopup(); // Mostrar el popup si hubo un error en el login
            }
        }
