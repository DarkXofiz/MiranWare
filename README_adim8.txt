ADIM 8 - kullanim (repo kokunde):
  1) zip'i repo kokune ac (build.gradle + 2 script ustune yazilir)
  2) python3 adim7_patch.py     (guncellendi: Camera.position()/yRot()/xRot())
  3) python3 adim8_patch.py     (logdaki 115 hatanin duzeltmesi + stub siniflar)
Iki script de idempotent. Derleme yerelde dogrulanamadi (1.21.11 jar'i yok) - CI logunu at, adim9'u ona gore yapayim.
