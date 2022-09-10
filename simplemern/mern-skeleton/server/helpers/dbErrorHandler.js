const getErrorMessage = (err) => {
    let message = ''

    if (err.code){
        switch (err.code){
            case 11000:
            case 11001:
                message = getUniqueErrorMessage(err)
                break
            default:
                message = 'There is a problem'
        }
    }
    else {
        for (let errorMesg in err.errors){
            if (err.errors[errorMesg].message) message = err.errors[errorMesg].message
        }
    }
    return message
}

export default {getErrorMessage}