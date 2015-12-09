<h3>Ready to send messages</h3>

<g:form action="send">

<table>
    <tr><td>Name</td><td><g:textField name="name" value="${name}"/></td></tr>
    <tr><td>Message</td><td><g:textArea name="message">${message}</g:textArea></td></td>
    <tr><td></td><td><g:submitButton name="submit"/></td></tr>
</table>

<g:if test="${json}">
    <p>Message sent:</p>
    <pre>${json}</pre>
</g:if>

</g:form>
