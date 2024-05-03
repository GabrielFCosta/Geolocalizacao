#### Geolocalização no Android em Java
> O serviço de localização no Android funciona por meio de retorno de chamada (callback).
> 
> Um LocationManager deve ser programado para receber atualizações de localização por meio do método requestLocationUpdates().
> 
> As atualizações são passadas a um LocationListener, que implementa vários métodos de retorno de chamada, que o LocationManager chama quando o local do usuário é alterado ou quando o status do serviço é alterado.
#### public interface LocationListener
> Recebe notificações do LocationManager quando o local ou status do serviço são alterados.
> 
> Possui os seguintes métodos abstratos, que são chamados pelo gerenciador de localização:
>  - OnLocationChanged: Chamado quando a localização é alterada.
>  - OnProviderDisabled: Chamado quando o provedor de localização é desativado.
>  - OnProviderEnabled: Chamado quando o provedor é ativado pelo usuário.
>  - OnStatusChanged: Nunca é chamado (deprecated in API level 29).





#### References:
##### https://developer.android.com/guide/topics/location/strategies
##### https://developer.android.com/reference/android/location/LocationListener
##### https://developer.android.com/reference/android/location/LocationManager
##### https://developer.android.com/reference/android/location/Criteria
##### https://developer.android.com/reference/android/location/Location
