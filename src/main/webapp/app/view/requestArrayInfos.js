Ext.define('IncrementApp.view.requestArrayInfos', {
    extend: 'Ext.form.Panel',
    alias : 'widget.arrayForm',
    frame: true,
    title: 'IncrementsIt Game',
    width: '800px',
    bodyPadding: '10 10',
    
    defaults: {
        labelWidth: 400
    },
    html :'Tips : don\'t set values to get a random array !',
    items: [{
        xtype: 'textfield',
        name: 'arrayItems',
        fieldLabel: 'Values to increment (please use comma(,) as separator)'        
    }],
    
    buttons: [{
        text: 'Increments !',
        action: 'login'
    },
    {
        text: 'Reset field',
        handler: function() {
            this.up('form').getForm().reset();
        }
    }]
});