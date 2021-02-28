function salaEvento(){
    const salaSelect = document.querySelector("select[name=sala]")

    fetch("http://localhost:8080/salas/list")
    .then(res => res.json())
    .then(salas => {
        for(const sala of salas){
            salaSelect.innerHTML += <option value="${sala.id}">${sala.name}</option>
        }
    })
}

salaEvento()

document
.querySelector("select[name=sala]")
.addEventListener("change", () => {
    console.log("mudei")
})