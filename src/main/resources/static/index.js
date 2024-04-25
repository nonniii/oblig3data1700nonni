$(() => {
    // Legger til en klikk-handler for kjøp billett-knappen
    $("#kjopBillett").click(function() {
        console.log("click handler running");
        // Henter alle input-feltene og validerer verdien
        const film = $("#film").val();
        const antall = $("#antall").val();
        const fornavn = $("#fornavn").val();
        const etternavn = $("#etternavn").val();
        const telefonnr = $("#telefonnr").val();
        const epost = $("#epost").val();

        let valid = true;

        // Validerer antall billetter
        if (isNaN(antall) || antall < 1 || antall > 10) {
            $("#antall-error").html("Antall billetter må være et tall mellom 1 og 10");
            valid = false;
        } else {
            $("#antall-error").html("");
        }

        // Validerer fornavn
        if (!fornavn.match(/^[a-zA-Z]+$/)) {
            $("#fornavn-error").html("Fornavn må kun inneholde bokstaver");
            valid = false;
        } else {
            $("#fornavn-error").html("");
        }

        // Validerer etternavn
        if (!etternavn.match(/^[a-zA-Z]+$/)) {
            $("#etternavn-error").html("Etternavn må kun inneholde bokstaver");
            valid = false;
        } else {
            $("#etternavn-error").html("");
        }

        // Validerer telefonnummer
        if (!telefonnr.match(/^\d{8}$/)) {
            $("#telefonnr-error").html("Telefonnummer må være på 8 siffer");
            valid = false;
        } else {
            $("#telefonnr-error").html("");
        }

        // Validerer epost
        if (!epost.match(/^\S+@\S+\.\S+$/)) {
            $("#epost-error").html("Epost-adresse må være på formatet navn@domene.no");
            valid = false;
        } else {
            $("#epost-error").html("");
        }

        // Hvis alle feltene er gyldige, legger vi til billetten i listen
        if (valid) {
            const billett = {
                film: film,
                antall: antall,
                fornavn: fornavn,
                etternavn: etternavn,
                telefonnr: telefonnr,
                epost: epost
            };

            bestill(billett)
        }
    });

    const bestill = (billett) => {
        $.ajax({
            url: "/lagre",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(billett),
            success: bestillSuksess,
            error: function(error) {
                console.log("Error:", error);
            }
        });
    };

    const bestillSuksess = () => {
        console.log("bestill suksess is running")

        hentAlle();

        $("#film").val("Ant-Man");
        $("#antall").val("");
        $("#fornavn").val("");
        $("#etternavn").val("");
        $("#telefonnr").val("");
        $("#epost").val("");
    }

    function hentAlle() {
        $.get("/hentalle", function( billetter ) {
            let billettHTML = "<ul>"; // Bruk ul i stedet for list
            billetter.forEach((billett) => {
                billettHTML += "<li>" + billett.antall + " billett(er) for " + billett.film + " på navn: " + billett.fornavn + " " + billett.etternavn + " " + billett.telefonnr + ", "
                    + billett.epost + "</li>";
            });
            billettHTML += "</ul>";
            $("#billetter").html(billettHTML);
        });
    }

    // Legger til en klikk-handler for å slette alle billetter
    $("#slettAlle").click(() => {
        $.get("/slettalle", function (){
            hentAlle();
        });
    });
});











