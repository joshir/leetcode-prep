package joshir.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class KLengthSubstringsWithNoRepeatedCharacters {
  public int numKLenSubstrNoRepeats(String s, int k) {
    if(k==0 || k > s.length()) return 0;
    if(k==1) return s.length();

    Map<Character, Integer> map = new HashMap<>();
    map.put(s.charAt(0),0);
    char curr;
    int count = 0;
    for (int left = 0, right = 0; right < s.length() - 1; ){
      curr = s.charAt(++right);
      if(map.containsKey(curr) && map.get(curr)>= left)
        left = map.get(curr) + 1;

      if((right-left+1)%k == 0) {
        left++;
        count++;
      }

      map.put(curr, right);
    }

    return count;
  }
  public static void main(String[] args) {
    System.out.println(new KLengthSubstringsWithNoRepeatedCharacters().numKLenSubstrNoRepeats("fqezicakyohxbsbivjjglqrehiwpkcfdpxcjzwlmqqodnkarcedxqbdjhlbwqqcnykvyzvpaivzxyhasjsnlevolsvrnyvgkhturklmzqfhvjbeqhykuhacznphwwjpqgmcrunmpxjeqvkkllwcdhzhrbnbkomzptavjhxvhvohvueurpadgwroffoittvrtpielprkytusndrhbojcvrcfxkxvlvwrsqskibucyctgmevxnvkvluyupqytbygjonxjkllupjwmrxyqaqxcxpmovqxwqglljkyqwjwebmozigszwgkzhignpxphathukvbqodntqsxeionmtqsbnfcvrqdrzcvgrraatzxstpahdpfpxpuvylfirxfwsxwhdaereeghvvgygtpftezegkkrdxahloeagrgruebyymvksghypqpktqptxwedkpflpkcgstpsfbgkymdsiosgynqdqashsquuwitldtdqzonnzyqtlmzlppolwxjjzgrmwuonccamgbcsamfdozpjpyvqmoxfinonuqvxipbabhvxukwkgwmfkdersfeyrbcfmrgskczeojqlyqhgqemgtensfrducoetocaufhfqafxrluekuwxhkparpmtbkwuvocweywasdbjdpcebiuryaoyvuywfxumvssckjhgsysbpposaonqdydexeglttivxenurzhctnsxapdcficrintkemmpypqpaiwxskmibqtxgutuaxgbswumhfxutqaykvvmtfugpburtosrhcgkniohhxzgyvmxhktahonjvctllqtcyxcwbkdzbkroidyvytbrjwlubvrfqyarifpjrndbrbivocjaddrxopwhhaswssnernghkyxlfrapwnnytvulexgerxxcnjcxrxaubtdxauopzuccmjigshyosvjmdlbtlwczyzgsuwvdsmofawjrfgwnlsutomijjsefiwvqwtqonmrddalkhdklmbdraphrsffmuvlmoqevdtighvspdtbrborbrnobwikkacmhodyutbvtllhherlqgkjmkfswfpuzxyfbzgadmxmwjaghcyekjxqkdotyehqvgfaqzyjhmyrjylypimohfqbdiyztjidywbscchqtbhmbwmaxjllemctsywpowyqxzdsyemulvbfgllrwaepzxtucoobmzdtmfeablzuwpjxuucehficqevlrenfvgbnufrldociufigzpsjccmsdjwntprjhebfojbggmfpyfjqhszpmnosqneqpgdvnwvnuhljaaamxulxmhdhudvxysndscpfahaurfucmllcbzzhzrmwsimyaebauagbajszvaezbwssjpqfokcfogcbtjediqqqvorxuxpifihxthlftacotelfgjozlcmuekqryleiaakxhbvdociuejpitjyzfjxflojalughleuzdlslasfhxsrsaqnhzhymqbfzxlihdonchmjtmyubjsepawtarggkaipqbjeswlsvzzeustpymvtvvdvtpimnybncosxrkzvxwncifrpczvfzffmtjodekcoyrrfojebalblvrshcvzurhckhndsnqddlofszihwtyvanavpicwoqpzuofgigefygryjksgxtreeghyzrjfcbtswugpbmvevrlrwhjlzfaxqxzbdoizddzhimvdoveiozedhaljqudaqeoozvdmmgxvaayjtuniljxhlfnygeewidmgjxjvbnniietnzwumtmfhftgmdiqwdeofjhpxdqhrkueqmmayjnasmsegpfqgyredygrsaasmqqjixngjlshvzejuoywrtgwjvlmybwtpotiekzrreqqmgghkscyyucjjcntuwwzfebwyydokrwkarsbvvrifkbwmknqsehtumqfevzsjafpptbkrtcutwlzelpickyggysgqmvxqkaiqwoyahlepfmwjccfwnlmbbocjojmfltqwktnyyufpfqpblptqiwuxtybksyzqvjpqaeweirxsfmlihluomoojnzmftqsktxmrimvlswrrjufdkxkoukqcrkanclzjtslrdnqqoekmoezcizhibordqirhenpdklupgxyxkpgmsglepuchuljwwztzhwtzerqjkeohlkwwgwiplxqhtxlbiwfkjcdzldagjkwxnuzvjwnlckucfjoypdqptxkdrdnvtxmbjtfjevujmcubktfyvecdnguwisdavwzdtwqsotbhtpajpizuyopajzlytxgqwhxlbftsgawxvmkgmnrdswghawwzygdaxxprhwmapfmlydpdqifzxuevuidgggzdbbmsxigqyfegpdgllzxybtpoultffmdpccfozmqoiaecmtcrwbrcssmtxmnyfpbpcwxuhgijvbmdefsxlmzepqaxoajhxqboultkyxdovmxyrkqijarcxmjckhjpliqghgnwigzuxxwfczytjrnochqzkjhbskzecifrscbuhjtgnruyqlwxflxxjtqgbuupvevzckemjiygtnxuxgclztsaszqyofpdtljubvcxidtrvtichcveqsfpentvqsffqbvyrdzyglzzzuavfcavfjypgfltgqfucdbajfwhcgrhnnjtmmbwohzhbfmdiahwazomowewjwrfjtjyhmmrrijfoncuwgmucriswvbgiirzdthjsfxxsppwgsgdcjxvyinbyfenyoxtvsklismadpvjnewvqoqszadxryspwsksbpzzrbfkyvpaylgvrszpkllqdjjarovedckokzthhehsbbbaiifiynafgahscaudbqzkdkydcadqbmvpjeffyuusyltdasqeokjcniktpmdyotujlttrscotfsqlopjhosdlzszwowmnrumodauixxspsjooxljrsjnhucwefeuubzvurspovqcmgfuizwbcajhleeapigsdhsbykgoixdtidikdfyrgdgggvkxzrcrvwbcokijruuaroxbfvdctdflegwocoxtpzqtngbhmznjeyjqucegfqvpcmazfkhxhfyrpernaomazrunfcdjtvcizxeedjzgqtzrwpwtlskyokjtfcoqnyvcdrlaioyenwdsllmubilnczzsqypocorgddtfawgnkjmbzmfaxfdxfwhajwypsttbiwcaphkyczcizewjfpkvjdiogflpvdexkxamngnaammqqjhzvkgixffzqrhzcergaicfneunhzarzxlkrfqudqzdakkxdjoktcyfdxklgierjupoejgpldmhpvcyeymburyoltuzxempthhdpfcsuuratzgabeslrawxainsmbuzqmqhfuajkndobqhjnjhzzfslaojskknceewqwkiejbkuekpcebeklztybyfuisnahbblpblqqmlwggjeiyckvxbyqbgbnofhvzzinizolpgsmkjhydthowpjlvpzqosnzjiagkkkckcczyzramulfqhsqjfrxazsejdojoiwanbsofsjqcmwyjfkcqilyfkrhewyhelfegturbubrkdcalrvtqrdowspwvyqilfbboftafukhcnwoqexladxvfvntsixdmnjgffigdtmkqpuuxxhbcfhzmsowxpelifjsqtjfhqnhqtlhdusreijysysiumkydrtyokazqsysqmcuphofbympmbthhrnpgbqprhzmgflnwpnyeudgdovnlqaxypjdvdtlnusjrqremknbphbcpvsttitprznaracciznteltwmiftozbbtcjtxxchkecljihmxbrrwcerqavzecijzqqgvjbhjfsrihvprchpanzlrrjtbeytbdzzwbfodulzpxssrahshmjjiwkdpjppnmuomivmlofiokeesxfrnuatdkjxbigphcokgydtjeawutcmmuxebxgxxqyzfvpiaunktyucarkfxipyvjhsrnzqrapxdbawmveyyignaocmkxhybxvcwezwxjpjojcruqmnmnpcrlwowqywfdewriclgavtjgcomnlkyxodmddwavhvpkmnpiyuoqxvfnmdqryxrnutnievwpucesaeayczbwihpgualfivgsnezqjjdvpaaodiduuelujjisbopezbambwctdemjoregvdbsqcorivbpojbvbyybpoyhplaatlcunnfujjwyxhqltxaufopqnitbhnwxewgcsuoxznrghnyysoqwinvlxkvfldvatqkocrrlqtlkjspzurjquthrmtegasxkgayxncmjuteyjswmdlvtxvholzolragspjulatnalbmnatzkppekynuyqqciwgukcxyvzhubbhfyhixcjvgsirydtrsivhpclmwoxnzvfmrooiqbgqprzgsmpqnznbmktysjrevatmfslxfgglnsqnaiahhvfjiquzsfpldfldhmjislvekgqbulcywayiedqwmmkeyccsaffkatpxpdxpxbkezyskrxqzkvctyvopbgxioklmbeqnpkxcyoxaccloilylyvjkimkzncqdkfpeywfjocozhcvsxbzbumygcqltmkytvtcuksobabqhpiwpfgbufncfeegggyprkqhmbqtpgittxegwtewjjzptmptbudklgmcngyqmogjcccsrscjypbvjujhgqsckpunvpcmwqiyqaepkezfkpyhrygxvfanhsirjieyfggkubqdjweamhumtwqzqvmjhflhcyfbqelpdgnoqvcfagowvsrwctumcovdvolxyogqrhcpexnlrnonmyyuqanxmrvfedwimywitqbuaisksvgeimzbvzlzdukdupqknmeiclhzaaqqhhmjjyhnfkcoqvopajxlilaszeugwvuwnftkgpzqnqaikcqrymsysyjwwszporrhlzbmtwvcmuxautzcrjdbvxcwkxgmyspfrypmcnocebcimwccmqcnjnqtqxkmbdjjgxsomjgxwuhstzmcrnhszqwuaxevjbqrnxhutobkpmkmsrltbbaopqqytvidpczccgnclswltkjavisfrlhiwsdtguaevlddibizhcuwxpqozxhdbgnnewxbfindbsxcognyxmdyquiknesuivkzbbmwbcbfxasumqgpxrfccahuqqvejiuoplkmbuokxrmxntbpsreuemfoudcfjtmvairvpnqdvaadmswqakwedtiudwuuplzkuyeiaonmxxrfgowgvollnkymgsdwdllfltvhdwrrmelqfgtkitcadlnhrxaztifrmtrjtkfzfbhwjrveddthczkbwfmtykvjmkxdgllgjoriyueqgtphwkjiyuvtrenzxtjvraippntdhiatvxwnwjwfxiyefydxnkyclqpgdsrdecaupycthwaxhprkiumahmgeqwlhdvjrpjvdgmtroyykwnrsjbssabxrbzifjgkvtgfwszbkwgaomhkfztbhyrfbnyodsxkxzyduyumpfjdjyqkhoijwshecmdbjjwczgdwyorjapkfyxgujrhycrfngjnrpnyrbdogwypjshmistgczrbbzyawdhkayevubynuqbncnikbxkxevzzkjdtqvcxqqyagqmbxsrdesjrejwnrlbuxtgwicrelsnllngkrdyzekrquvbnkbzymztvzdtgciizmucdaghrszymssghhzufpwlkqgizlqvasyqpefsorgzueadreaoaiykfpmlhgdsbmsfblabvqnkiinijlvvvlvoefthrauqvvjfiwquvhyqjprmhjsvorgindyswhbtkjgqfrrqbluuvbrdpvptoimeikyzpnsnqxsetktzvcsclqsejrycfcvurfdnjgahnewpblrrdymtvachpxxtwwlplocjjunrzxcfmfifhdteqldudaikdmttpmtzkfsvrbscpaipcrkyavucpemqulzynujeyffmkzqyxfplablpenoqbcpkavczybsldrwagbgnyzcqcrbaczrbzlianoyyyqpsglahfoonlzzsqiwojtxwxhcjfwvbuyjqvbvdndraiizhfrbrirgaohdmhygumjeodbwbbcnuyudctpruodlsekoeeohqrmbiivofxtvvfoityjxkkoxwkhgvebbnzkefnqxdejetqkluyjotqoiwchdfnpnzovtwyopkowsjxgtyrwfsmfkrdrdqeuhdwppvwbioyvqndsnllldcrrplnijnznzhvxhredjakdjtuvmhknzmlegvssgkcmxbzpkjpproyvxupvbjyvliaygxwumtcjuykugyilyqotydxqslpbzarctbmpblxcnqelrkcmawesblpgerlcuakqlazrchyrarzswuorpymymuixilibsdsijwodyibybwekubbcobizormujmkpqpjcmrcpbsrfozrdkjgtczwtatfpjwsbnknimbdraokrqovjouipxnohiauxmholljxthlptmzfsqhslotmexhqfdpfbguzqbvfbatorphxkynlmxoimrxpztxeyltldvpryptdwenlgrfmcibpryiduhuormalnfquogcxalsczrguwdkzlysftsdlknslvkexpgskmarrjgwaxwfnwjphsilsojzlvtnoewfxhrcntzwmikvvvllsjhexpgbzypezhkhuegcbvqdmiyuumjlyeynrduboqwqniohvinxknytumuwtnsnuusbscqrbpaucrdedpdmqafaumdsfuwjfervrcubunprmmpxmyvaqghymhifufnypaevxknrdonviyvqhclngyflauzbofyueigedmoqrdofwjtnskdlbhamamgrcairegdhaiduvsnurtbyphjedoksiqoungvpzjlqneuhdckihgcougzkzgnxfmarfrzzxavgdnbcmegzpeoszbpfhhspunemcnqgspowglfvdoikvxglrhgxqyzghmvlvvzymeicomaemzodqddpcvkeixaofymmzbxdhsofaeygcneeffxuldwyskoisgtwjhotaneqmdvtxjtzpximmddvbvkwzlkzpjmacqvtwnzvazuelvuhnuxhyzutmtkzcbipbgatzokvxnyfiyimpwlwagwzqpkvoqsgobxljxdxfejkvcxkuaqxcxxyjgkwsjybtyxkngcbkgjvrzdrlvqmzrkmbwbzqsbzywcuubruenxvnfolafhxldvrwhzdfmocauellflmdocqqkqosnerzemcsejyoodiftkraqxppoyylwsaddktryluvzsnkukomunpjntgatzqyrngjvtpyyxvlvujmroklmlfprhzyjdrokdqmodiksexyzjateyounfrbcvohicrnhbqgrbrcgjmwtwpmnkhzciqroqbudslqsxrzkgjmrhkwuuokkodccqvvahxvtoovrdvvwmdbhhwyiziuxvajesbciqazkxlniwcyssttpgjfnsybsdiihcntglikwvwnsobonjxfadxpofuyascmdexxylotuegmtegcqlayuerdovcvbbtptyfwyakswmkjhyhdkfjtdlydnxsrnumeqisnayqokpwhsajtpbtbylfawjkuoljjwqtyifbgohjvcxedolpnlnmfkpgrbiimqdlinprqbxmwecexsnrumfvikkiugjzgqmlbreqjvpgvidockzejtrirdnsgvetpxifymovadobrpukwzdjfefwwifeeywzmvjmrtlohejvducaozuslhqlbzcdjhdomuzxstntcrszlizrwtplwdrralwxpzxglbuyaceahusgupmnkgotsaelvnieanhprqtgczswwomngirqmbvgwgxrsaxnfxhfqaduleuzarmlqvoqoxeisxhrxfffnkliydjogsghqnukedkmiuflijjijyaqqkinpydtpvsxmufjtvkcahqfzzvovkulkmlgvyfkyibjvukxlbkackimjdhpnuttwqpjjvxjyoqzwojcwcerstzsefreslppjxfbwsblyjvwzaqjnnphboyvzdspgmtwsutwaappptwchrwxnmdslzyrtvtqgmroxztboosrfhidmicifzedfnbtzxonshcrhsxulpykjuzmkgkbmjnarmeysmhpluloygldzwwhnqndtknhpntpnfewvkvqbiyezdudtnxyywlgxsegrjypifnoxxyemfueuvusjhfwqucskjvjgmyumyfojdoychmpemtydlfesnyjaownkyuenxppiudsbfshwgyzgcaofnbxheomimyptficohtktxstvdqbsrizgzwxjmkvvsekvjsgmuyjcefoeqfvssnskaflueavinhtmwltuzslapmcadzkqgeimynlqjrfpqowitybnexelibnyhvamidmlfmbtysfbphkddcwpbrjqmmwnplfmbdsasmafubmbqmvbimjlyuidxgtwslxbglkmfqqugubeaciotiyaaohfdkiyimalchtsodrjqcmyhzrnhcdddasezfvsjpxntqedztwajcqdxmehfrfzxyqbidqoxkgbsccjauxaeocmezfasiszpetwiaphahdnucihndwasvcewwizihqasnvmgxuvcltxkzutwmcecmtkvwkeiepzuwduzzhvvcckbljkcdrnrfevxgnghvuhsltwagkdzntylqradlfoxszltmqxyukxqkirmzledssynvpwhxhnlyfipufokdwahjcwypqjhnzlkxyhjxvmwovhvjqrvvuddhdxkhhjhvojzucqmndbquajmjswsxdlvhnsrkllqnhajtbcgozirvqbnfbrclqyyziayzpayfpqqpbgmygxojjlcfpqotpjydhigvpjvddajwkbcfearsqckhirrfdshwrksxgddebrnszylifyjknwlwfgzhnaxtymmzadekmiroxijossltuqlvkzrtdpuggifhkgguvocftabffcofbonkfesqiotlpvkzxjhgfpufkdqlsvdaslxxjdnfhmaevtuuehoksrwvotupcrwcdurdeinecmnkbtmjothvecqzjndzhcyhuwpsibhvutegzztvrxupizoantywrfoklihwclltuykogihwlcrdgqodeishfiuhqvxwyaonogrwskzylscwakismybslwfzjophixjgvqhlnbipueiccxbkbuqphdzzamsprygawbqbvzhnjqxfwmdneeocgnsrjkcmrafxjwiuegloppvtbbvftpbymsxluwrjijfefgsxtsmbsiuhmqwzipwrhivcbxycvreildfrbllwfwxrhzgiifrvkjsprtbnsazjaihmubpcgsmrqwykqwdutfoycdpvrqlxcdxacwrmuverljiiknesaqbomthhcfdfevwopgiaemkxywarvbezbauycavfnrwurautzrcdykcvupzzshmvesuadidfkyyxlxibbsanewiaiaepumsfystozmsyfcgmlpsufbazudjocfphkqekejhbbqambdtzwjlvcpcyimzbtcvzqqopmldaqjiczrjpitogugubzvikcrpfpyqfujxtfipvcvfhofeflphbuzoaiwunpbsngbkftskcpidtjizngyheimxbpsrdztkpaclsuyoojwepbvsilnsgmzrllbjworpwdhytavfufwsrxzhyqqwdwefiqawnufnywyopoiutqwrnmxoljcpmwkptpkdhguanzdaceyrebeabdhtlxgebswjdmbrmtolowshhcckuembqynamcalzedlexkpqmiyyrrawyczldzfveoaxscddgspglasrzvixqiehzxwctjgssmjoutxzgoyaobyqxcpjunbhqdeoudslaibdgwsbhawxulugfyrlhzcxgnbgppbqjeezwt",1));
  }
}
