import { LoginPage } from '../../page-object/login-page.js'
import { HomePage } from '../../page-object/home-page.js'

describe('Swag Labs', () => {
    const loginPage = new LoginPage()
    const homePage= new HomePage()
    beforeEach(() => {
        cy.visit('https://www.saucedemo.com/')
    })


    it('should be able to login', () => {
        loginPage.login('standard_user', 'secret_sauce')
        homePage.getTitle('Swag Labs')
})

})
