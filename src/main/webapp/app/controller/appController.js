Ext.define('IncrementApp.controller.appController', {
            extend : 'Ext.app.Controller',
            views : ['requestArrayInfos'],
            
            init : function() {
                this.control({
                            // Click on "increments it"
                            'arrayForm button[action=login]' : {
                                click : this.incrementRequest   
                            }
                    });
            },

           
            incrementRequest : function(button) {
                var form = button.up('form').getForm();
                if(form.isValid()){
                    Ext.Ajax.request({
                        url : 'MyServlet',
                        method:'POST', 
                        params : {
                            arrayDatas: Ext.encode(form.getValues())
                        },
                        scope : this,
                        success : this.success,
                        failure : this.fail
                }); 
                }
            },
           
            fail : function(err) {
                Ext.MessageBox.alert('Error occured during request', 'Please try again!');
            },

            success : function(response) {
                response = Ext.decode(response.responseText);
                if(response.success){
                    Ext.MessageBox.alert('Incremented Array', response.message);
                }
                else {
                    Ext.MessageBox.alert('ERROR', response.message);
                }
        }
    });