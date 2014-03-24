var RBEWebservice = {
    callWebservice: function(){
        // So chama se houver comunicacao
        if (RBEWebservice.hasConnection){
            return cordova.exec(RBEWebservice.webserviceSuccess, RBEWebservice.webserviceFail, "RBEWebservice", "webservice", []);
        }
    },
    hasConnection: function(){
        var networkState = navigator.network.connection.type;
    
        // Se tiver conexao
        if  (networkState!=Connection.NONE && networkState==Connection.UNKNOWN){
            return true;
        }
        
        return false;
    },
    webserviceSuccess: function(){
        
    },
    webserviceFail: function(){
    
    }
};

