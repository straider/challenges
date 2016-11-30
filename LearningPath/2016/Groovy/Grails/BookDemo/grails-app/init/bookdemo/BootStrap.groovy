package bookdemo

class BootStrap {

    def init = { servletContext ->
        new Book( author: 'Stephen King'   , title: 'The Shining'         ).save()
        new Book( author: 'James Patterson', title: 'Along Came a Spider' ).save()
    }

    def destroy = {
    }

}
