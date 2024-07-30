/// <reference types="cypress" />


export class LoginPage {

    login(name, password){

        cy.get('[data-test=\'username\']').type(name)

        cy.get('[data-test=\'password\']').type(password)

        cy.get('.submit-button').click()

    }

}