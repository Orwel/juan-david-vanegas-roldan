window.addEventListener('load', function () {
    (function () {
        const url = '/odontologos';
        const settings = {
            method: 'GET'
        };

        fetch(url, settings)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {
                const table = document.getElementById("dentistTable");

                data.forEach(dentist => {
                    const dentistRow = table.insertRow();
                    const tr_id = `tr_${dentist.idOdontologo}`;
                    dentistRow.id = tr_id;

                    dentistRow.innerHTML =
                        `<td class="td_id">${dentist.idOdontologo}</td>` + // Update the <td> element for the id
                        `<td class="td_nombre">${dentist.nombreOdontologo.toUpperCase()}</td>` +
                        `<td class="td_apellido">${dentist.apellidoOdontologo.toUpperCase()}</td>` +
                        `<td class="td_matricula">${dentist.matriculaOdontologo}</td>`;
                });
            })
            .catch(error => {
                console.error('Error:', error);
            });
    })();

    (function () {
        let pathname = window.location.pathname;

        if (pathname === "/odontologoLista.html") {
            document.querySelector(".nav .nav-item a:last").classList.add("active");
        }
    })();
});