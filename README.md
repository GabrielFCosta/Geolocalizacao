### Geolocalização no Android em Java
> O serviço de localização no Android funciona por meio de retorno de chamada (callback).
> 
> Um LocationManager deve ser programado para receber atualizações de localização por meio do método requestLocationUpdates().
> 
> As atualizações são passadas a um LocationListener, que implementa vários métodos de retorno de chamada, que o LocationManager chama quando o local do usuário é alterado ou quando o status do serviço é alterado.
### public interface LocationListener
> Recebe notificações do LocationManager quando o local ou status do serviço são alterados.
> 
> Possui os seguintes métodos abstratos, que são chamados pelo gerenciador de localização:
>  - OnLocationChanged: Chamado quando a localização é alterada.
>  - OnProviderDisabled: Chamado quando o provedor de localização é desativado.
>  - OnProviderEnabled: Chamado quando o provedor é ativado pelo usuário.
>  - OnStatusChanged: Nunca é chamado (deprecated in API level 29).
### public class LocationManager
> Fornece acesso aos serviços de localização do sistema.
> 
> Esses serviços permitem que aplicativos:
>  - Obtenham atualizações periódicas da localização geográfica do dispositivo.
>  - Acionem um Intent específico quando o dispositivo entrar na proximidade de uma determinada localização geográfica.
>
> Todos os métodos da API de local exigem uma das permissões:
>  - Manifest.permission.ACCESS_COARSE_LOCATION
>  - Manifest.permission.ACCESS_FINE_LOCATION
> 
> Se o aplicativo tiver somente permissão para “coarse location” ele não terá acesso ao GPS.
> 
> Métodos utilizados no aplicativo de exemplo:
> - public String getBestProvider (Criteria criteria, boolean enabledOnly)
> - public void requestLocationUpdates (String provider, long minTime, float minDistance, LocationListener listener)
### public class Criteria
> Define os critérios de aplicação para selecionar um fornecedor de localização.
> 
> Os fornecedores podem ser solicitados de acordo com:
> - Precisão;
> - Uso de energia;
> - Capacidade de informar altitude;
> - Velocidade de deslocamento;
> - Direção;
> - Custo monetário.
### public class Location
> Classe de dados que representa uma localização geográfica.
> 
> Uma instância de Location pode conter informações de latitude, longitude, data e hora e outras informações, como direção, altitude e velocidade.
> 
> Todo local gerado pelo LocationManager tem por padrão latitude, longitude e carimbo de data / hora válidos, todos os outros parâmetros são opcionais.
#### Fontes:
##### https://developer.android.com/guide/topics/location/strategies
##### https://developer.android.com/reference/android/location/LocationListener
##### https://developer.android.com/reference/android/location/LocationManager
##### https://developer.android.com/reference/android/location/Criteria
##### https://developer.android.com/reference/android/location/Location
