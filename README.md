# SpaceSample
Executar pelo Netbeans:
	-No NetBeans vai em Tools->Libraries
	  -Clique em New Library
	    -Library Name : LWJGL-2.9.3
            -clique em OK
          -Encontre LWJGL-2.9.3 no canto esquerdo e clique nela
          -Em ClassPath clique em "Add JAR/Floder"
	    -va na pasta SpaceSample->lwjgl-2.9.3->jar
 	      -escolha os seguintes arquivos:
		-jinput.jar
		-lwjgl.jar
		-lwjgl_utils.jar
	      -add estes jars
	  -Em Sources clique em "Add JAR/Floder"
	    -va na pasta SpaceSample->lwjgl-source-2.9.3->src
	      -escolha as pastas 'generated' e 'java'
              -add estas pastas
          -Em Javadoc clique em "Add ZIP/Folder"
	    -va na pasta SpaceSample
   	      -add lwjgl-docs-2.9.3.zip
	-Pronto biblioteca adicionada
	-No projeto, clique com o botao direito e va em propriedades
	  -va em Run
	    -altera o path que esta em "VM Options" para onde esta no seu pc o SpaceSample->lwjgl-2.9.3->natives->${seu SO}/ 
