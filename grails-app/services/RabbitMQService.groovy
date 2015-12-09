import com.budjb.rabbitmq.publisher.RabbitMessagePublisher
import grails.converters.JSON
import grails.util.Environment

class RabbitMQService {

    RabbitMessagePublisher rabbitMessagePublisher

    def send(message = [:]) {
        def json = message as JSON
	json.prettyPrint = Environment.currentEnvironment != Environment.PRODUCTION
	def text = json as String

        log.info "Sending ${message} as:\n${text}"

        rabbitMessagePublisher.withConfirms { channel ->
	    send {
                exchange = "some.exchange"
                routingKey = "some.routingKey"
                body = text
            }
	}

        log.info "Sent."

	return text
    }

}
