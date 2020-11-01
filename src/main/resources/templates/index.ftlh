<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>Contact-List</title>
    <link rel="stylesheet" href="stylesheet.css">
</head>
<body>

<header>
    <h1>Contact List</h1>
</header>

<nav>
    <ul>
        <li class="add-button"><a href="/add.html">+</a></li>
        <#list contacts as contact>
            <li class="${(selected?? && selected.id == contact.id)?then('selected','')}">
                <a class="contact-link" href="?select=${contact.id}">${contact.lastName}, ${contact.firstName}</a>
            </li>
        </#list>
    </ul>
</nav>

<main>

    <form action="/" method="get">
        <label for="search">Search:</label>
        <input id="search" name="search">
    </form>

    <#macro row label id value>
        <tr>
            <th>${label}:</th>
            <td id="${id}-value">${value}</td>
        </tr>
    </#macro>

    <#if selected??>
        <table id="contact-details">
            <tbody>
            <@row "Vorname" "first-name" selected.firstName/>
            <@row "Nachname" "last-name" selected.lastName/>
            <tr>
                <th>E-Mail:</th>
                <td id="email-value">
                    <#list selected.emails>
                        <ul>
                            <#items as email><li>${email}</li></#items>
                        </ul>
                    </#list>
                </td>
            </tr>
            <tr>
                <th>Telefon:</th>
                <td id="phone-value">
                    <#list selected.phones![]>
                        <ul>
                            <#items as phone><li>(${phone.countryCode}) ${phone.areaCode}-${phone.number}</li></#items>
                        </ul>
                    </#list>
                </td>
            </tr>
            <@row "Beruf" "job-title" selected.jobTitle!/>
            <@row "Firma" "company" selected.company!/>
            </tbody>
        </table>
    <#else>
        <p id="no-contact-message">Bitte wählen Sie einen Kontakt aus</p>
    </#if>
</main>

</body>
</html>
