package server

import grails.rest.Resource

@Resource(uri = "/ships", formats = ["json", "xml"])
class Ship {

    static constraints = {
        notes nullable: true
        commissioned nullable: true
        armament nullable: true
    }

    static enum Rate {
        FIRST_RATE(1), SECOND_RATE(2), THIRD_RATE(3), FOURTH_RATE(4), FIFTH_RATE(5), SIXTH_RATE(6)

        int value

        Rate(int value) {
            this.value = value
        }
    }

    static hasMany = [armament: Battery]

    String name
    Rate rate
    Date commissioned
    String notes
}

