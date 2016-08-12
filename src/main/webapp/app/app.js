Ext.Loader.setConfig({ 
    enabled: true 
    });

Ext.application({
    name: 'IncrementApp',

    appFolder: 'app',
   
    controllers: [
                  'appController'
              ],

    launch: function() {
        Ext.create('Ext.container.Viewport', {
            items: [
                {
                    xtype: 'arrayForm',
                }
            ]
        });
    }
})