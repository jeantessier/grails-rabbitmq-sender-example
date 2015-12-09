class SendController {

    def rabbitMQService

    def index() {
        [ name: params.name, message: params.message, json: params.json ]
    }

    def send() {
        def name = params.name ?: "Jean Tessier"
	def message = params.message ?: "Hello world!"
        def json = rabbitMQService.send(date: new Date(), name: name, text: message)
        redirect action: "index", params: [ name: name, message: message, json: json ]
    }

}