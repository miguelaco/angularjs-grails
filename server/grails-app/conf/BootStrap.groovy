import grails.converters.JSON
import server.Battery
import server.Ship

class BootStrap {

    def init = { servletContext ->
        JSON.registerObjectMarshaller(Ship) {
            def output = [:]

            output['id'] = it.id
            output['name'] = it.name
            output['rate'] = it.rate.value
            output['commissioned'] = it.commissioned[Calendar.YEAR]
            output['armament'] = it.armament

            return output;
        }

        JSON.registerObjectMarshaller(Battery) {
            def output = [:]

            output['id'] = it.id
            output['location'] = it.location
            output['number'] = it.number
            output['caliber'] = it.caliber
            output['type'] = it.type

            return output;
        }

        new Ship(name: "HMS Victory", rate: Ship.Rate.FIRST_RATE, commissioned: new Date().copyWith(year: 1778))
                .addToArmament(new Battery(location: "Gundeck", number: 30, caliber: 32, type: Battery.Type.CANNON))
                .addToArmament(new Battery(location: "Middle gundeck", number: 28, caliber: 24, type: Battery.Type.CANNON))
                .addToArmament(new Battery(location: "Upper gundeck", number: 30, caliber: 12, type: Battery.Type.CANNON))
                .addToArmament(new Battery(location: "Quarterdeck", number: 12, caliber: 12, type: Battery.Type.CANNON))
                .addToArmament(new Battery(location: "Forecastle", number: 2, caliber: 12, type: Battery.Type.CANNON))
                .addToArmament(new Battery(location: "Forecastle", number: 2, caliber: 68, type: Battery.Type.CARRONADE))
                .save(failOnError: true)
    }

    def destroy = {
    }
}
