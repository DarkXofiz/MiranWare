// Original binary: sg/ec/W03Ut4gfRvMI1nB4
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

// $VF: Compiled from s
public final class ParticleConfigCodec {
   private static final double field12741 = 0.04;
   private static final double field12742 = 0;
   private static final double field12743 = 0;
   private static final Identifier field12744 = method05962(ParticleConfigCodec.field13377);
   private static final Identifier field12745 = method05962(ParticleConfigCodec.field13378);
   private static final Identifier field12746 = method05962(ParticleConfigCodec.field13379);
   private static final Identifier field12747 = method05962(ParticleConfigCodec.field13380);
   private static final Identifier field12748 = method05962(ParticleConfigCodec.field13381);
   private static final Identifier field12749 = method05962(ParticleConfigCodec.field13382);
   private static final Identifier field12750 = method05962(ParticleConfigCodec.field13383);
   private static final Identifier field12751 = method05962(ParticleConfigCodec.field13384);
   private static final Identifier field12752 = method05962(ParticleConfigCodec.field13385);
   private static final Identifier field12753 = method05962(ParticleConfigCodec.field13386);
   private static final Identifier field12754 = method05962(ParticleConfigCodec.field13387);
   private static final Identifier field12755 = method05962(ParticleConfigCodec.field13388);
   private static final Identifier field12756 = method05962(ParticleConfigCodec.field13389);
   private static final String[] field12757 = new String[]{
      ParticleConfigCodec.field13390,
      ParticleConfigCodec.field13391,
      ParticleConfigCodec.field13392,
      ParticleConfigCodec.field13393,
      ParticleConfigCodec.field13394,
      ParticleConfigCodec.field13395,
      ParticleConfigCodec.field13396,
      ParticleConfigCodec.field13397,
      ParticleConfigCodec.field13398,
      ParticleConfigCodec.field13399,
      ParticleConfigCodec.field13400,
      ParticleConfigCodec.field13401,
      ParticleConfigCodec.field13402,
      ParticleConfigCodec.field13403,
      ParticleConfigCodec.field13404,
      ParticleConfigCodec.field13405,
      ParticleConfigCodec.field13406,
      ParticleConfigCodec.field13407,
      ParticleConfigCodec.field13408,
      ParticleConfigCodec.field13409,
      ParticleConfigCodec.field13410,
      ParticleConfigCodec.field13411,
      ParticleConfigCodec.field13412,
      ParticleConfigCodec.field13413,
      ParticleConfigCodec.field13414,
      ParticleConfigCodec.field13415,
      ParticleConfigCodec.field13416,
      ParticleConfigCodec.field13417,
      ParticleConfigCodec.field13418,
      ParticleConfigCodec.field13419,
      ParticleConfigCodec.field13420,
      ParticleConfigCodec.field13421,
      ParticleConfigCodec.field13422,
      ParticleConfigCodec.field13423,
      ParticleConfigCodec.field13424,
      ParticleConfigCodec.field13425,
      ParticleConfigCodec.field13426,
      ParticleConfigCodec.field13427,
      ParticleConfigCodec.field13428,
      ParticleConfigCodec.field13429,
      ParticleConfigCodec.field13430,
      ParticleConfigCodec.field13431,
      ParticleConfigCodec.field13432,
      ParticleConfigCodec.field13433,
      ParticleConfigCodec.field13434,
      ParticleConfigCodec.field13435,
      ParticleConfigCodec.field13436,
      ParticleConfigCodec.field13437,
      ParticleConfigCodec.field13438,
      ParticleConfigCodec.field13439,
      ParticleConfigCodec.field13440,
      ParticleConfigCodec.field13441,
      ParticleConfigCodec.field13442,
      ParticleConfigCodec.field13443,
      ParticleConfigCodec.field13444,
      ParticleConfigCodec.field13445,
      ParticleConfigCodec.field13446,
      ParticleConfigCodec.field13447,
      ParticleConfigCodec.field13448,
      ParticleConfigCodec.field13449,
      ParticleConfigCodec.field13450,
      ParticleConfigCodec.field13451,
      ParticleConfigCodec.field13452,
      ParticleConfigCodec.field13453,
      ParticleConfigCodec.field13454,
      ParticleConfigCodec.field13455,
      ParticleConfigCodec.field13456,
      ParticleConfigCodec.field13457,
      ParticleConfigCodec.field13458,
      ParticleConfigCodec.field13459,
      ParticleConfigCodec.field13460,
      ParticleConfigCodec.field13461,
      ParticleConfigCodec.field13462,
      ParticleConfigCodec.field13463,
      ParticleConfigCodec.field13464
   };
   private static final String field12758 = "minecraft";
   private static final String field12759 = "ITEM";
   private static final String field12760 = "SPAWN";
   private static final String field12761 = "ADDITIVE";
   private static final double field12762 = 0.75;
   private static final double field12763 = -0.2;
   private static final double field12764 = -0.9;
   private static final double field12765 = 0.12;
   private static final double field12766 = 0.06;
   private static final double field12767 = 0.12;
   private static final double field12768 = 0.4;
   private static final String field12769 = "SCREEN";
   private static final String field12770 = "OPACITY";
   private static final String field12771 = "TRANSLUCENT_L";
   private static final double field12772 = 255.0;
   private static final double field12773 = 0.75;
   private static final double field12774 = -0.2;
   private static final double field12775 = -0.9;
   private static final double field12776 = 0.12;
   private static final double field12777 = 0.06;
   private static final double field12778 = 0.12;
   private static final double field12779 = 0.4;
   private static final String field12780 = "SCREEN";
   private static final String field12781 = "OPACITY";
   private static final String field12782 = "TRANSLUCENT_L";
   private static final double field12783 = 255.0;
   private static final double field12784 = 0.65;
   private static final double field12785 = -0.25;
   private static final double field12786 = -0.9;
   private static final double field12787 = 0.12;
   private static final double field12788 = 0.06;
   private static final double field12789 = 0.12;
   private static final double field12790 = 0.3;
   private static final String field12791 = "SCREEN";
   private static final String field12792 = "OPACITY";
   private static final String field12793 = "TRANSLUCENT_L";
   private static final double field12794 = 255.0;
   private static final double field12795 = 0.65;
   private static final double field12796 = -0.25;
   private static final double field12797 = -0.9;
   private static final double field12798 = 0.12;
   private static final double field12799 = 0.06;
   private static final double field12800 = 0.12;
   private static final double field12801 = 0.3;
   private static final String field12802 = "SCREEN";
   private static final String field12803 = "OPACITY";
   private static final String field12804 = "TRANSLUCENT_L";
   private static final double field12805 = 255.0;
   private static final double field12806 = 0.65;
   private static final double field12807 = -0.25;
   private static final double field12808 = -0.9;
   private static final double field12809 = 0.12;
   private static final double field12810 = 0.06;
   private static final double field12811 = 0.12;
   private static final double field12812 = 0.3;
   private static final String field12813 = "SCREEN";
   private static final String field12814 = "OPACITY";
   private static final String field12815 = "TRANSLUCENT_L";
   private static final double field12816 = 255.0;
   private static final double field12817 = 0.65;
   private static final double field12818 = -0.25;
   private static final double field12819 = -0.9;
   private static final double field12820 = 0.12;
   private static final double field12821 = 0.06;
   private static final double field12822 = 0.12;
   private static final double field12823 = 0.3;
   private static final String field12824 = "SCREEN";
   private static final String field12825 = "OPACITY";
   private static final String field12826 = "TRANSLUCENT_L";
   private static final double field12827 = 255.0;
   private static final double field12828 = 0.65;
   private static final double field12829 = -0.25;
   private static final double field12830 = -0.9;
   private static final double field12831 = 0.12;
   private static final double field12832 = 0.06;
   private static final double field12833 = 0.12;
   private static final double field12834 = 0.2;
   private static final String field12835 = "SCREEN";
   private static final String field12836 = "OPACITY";
   private static final String field12837 = "TRANSLUCENT_L";
   private static final double field12838 = 255.0;
   private static final double field12839 = 0.65;
   private static final double field12840 = -0.25;
   private static final double field12841 = -0.9;
   private static final double field12842 = 0.12;
   private static final double field12843 = 0.06;
   private static final double field12844 = 0.12;
   private static final double field12845 = 0.2;
   private static final String field12846 = "SCREEN";
   private static final String field12847 = "OPACITY";
   private static final String field12848 = "TRANSLUCENT_L";
   private static final double field12849 = 255.0;
   private static final double field12850 = -1.0;
   private static final double field12851 = 4.14;
   private static final double field12852 = 30.0;
   private static final double field12853 = 0.04;
   private static final double field12854 = 30.0;
   private static final double field12855 = 0.85;
   private static final float field12856 = 30.0F;
   private static final double field12857 = 30.0;
   private static final double field12858 = 4.14;
   private static final double field12859 = 30.0;
   private static final double field12860 = 0.04;
   private static final double field12861 = 30.0;
   private static final double field12862 = 0.85;
   private static final float field12863 = 30.0F;
   private static final double field12864 = 30.0;
   private static final String field12865 = "spear";
   private static final String field12866 = "spear";
   private static final double field12867 = 22.0;
   private static final double field12868 = -1.0;
   private static final double field12869 = 3.14;
   private static final double field12870 = 8.0;
   private static final double field12871 = 3.0;
   private static final double field12872 = 3.14;
   private static final double field12873 = 0.3;
   private static final double field12874 = 0.15;
   private static final double field12875 = 30.0;
   private static final String field12876 = "block";
   private static final double field12877 = 10.0;
   private static final double field12878 = 3.14;
   private static final double field12879 = 0.15;
   private static final double field12880 = 30.0;
   private static final double field12881 = 12.0;
   private static final double field12882 = 3.14;
   private static final double field12883 = 0.15;
   private static final double field12884 = 30.0;
   private static final double field12885 = -20.0;
   private static final double field12886 = 3.14;
   private static final double field12887 = 20.0;
   private static final double field12888 = 3.14;
   private static final double field12889 = 12.0;
   private static final double field12890 = 3.14;
   private static final double field12891 = 15.0;
   private static final double field12892 = 3.14;
   private static final double field12893 = -10.0;
   private static final double field12894 = 6.28;
   private static final double field12895 = 40.0;
   private static final double field12896 = 1.5;
   private static final double field12897 = 6.28;
   private static final double field12898 = 0.15;
   private static final double field12899 = 30.0;
   private static final double field12900 = 0.04;
   private static final double field12901 = 30.0;
   private static final double field12902 = 0.85;
   private static final float field12903 = 30.0F;
   private static final double field12904 = 30.0;
   private static final double field12905 = 3.0;
   private static final double field12906 = 3.14;
   private static final double field12907 = 8.0;
   private static final double field12908 = 3.0;
   private static final double field12909 = 6.28;
   private static final double field12910 = 3.0;
   private static final double field12911 = 0.15;
   private static final double field12912 = 30.0;
   private static final double field12913 = 0.04;
   private static final double field12914 = 30.0;
   private static final double field12915 = 0.85;
   private static final float field12916 = 30.0F;
   private static final double field12917 = 30.0;
   private static final double field12918 = 22.0;
   private static final double field12919 = -1.0;
   private static final double field12920 = 3.14;
   private static final double field12921 = 8.0;
   private static final double field12922 = 3.0;
   private static final double field12923 = 3.14;
   private static final double field12924 = 0.3;
   private static final double field12925 = 0.15;
   private static final double field12926 = 30.0;
   private static final String field12927 = "block";
   private static final double field12928 = 10.0;
   private static final double field12929 = 3.14;
   private static final double field12930 = 0.15;
   private static final double field12931 = 30.0;
   private static final double field12932 = 12.0;
   private static final double field12933 = 3.14;
   private static final double field12934 = 0.15;
   private static final double field12935 = 30.0;
   private static final double field12936 = -20.0;
   private static final double field12937 = 3.14;
   private static final double field12938 = 20.0;
   private static final double field12939 = 3.14;
   private static final double field12940 = 15.0;
   private static final double field12941 = 3.14;
   private static final double field12942 = 40.0;
   private static final double field12943 = 1.5;
   private static final double field12944 = 6.28;
   private static final double field12945 = 0.15;
   private static final double field12946 = 30.0;
   private static final double field12947 = 0.04;
   private static final double field12948 = 30.0;
   private static final double field12949 = 0.85;
   private static final float field12950 = 30.0F;
   private static final double field12951 = 30.0;
   private static final double field12952 = 3.0;
   private static final double field12953 = 3.14;
   private static final double field12954 = 8.0;
   private static final double field12955 = 3.0;
   private static final double field12956 = 6.28;
   private static final double field12957 = 3.0;
   private static final double field12958 = 0.15;
   private static final double field12959 = 30.0;
   private static final double field12960 = 0.04;
   private static final double field12961 = 30.0;
   private static final double field12962 = 0.85;
   private static final float field12963 = 30.0F;
   private static final double field12964 = 30.0;
   private static final double field12965 = 0.70016;
   private static final double field12966 = 0.308;
   private static final double field12967 = 5.1;
   private static final double field12968 = 0.70016;
   private static final double field12969 = 5.1;
   private static final double field12970 = 2.0;
   private static final double field12971 = 0.65245;
   private static final double field12972 = 0.16675;
   private static final double field12973 = 3.14;
   private static final double field12974 = 3.0;
   private static final double field12975 = 0.65245;
   private static final double field12976 = 4.4;
   private static final double field12977 = 1.3;
   private static final double field12978 = 4.78;
   private static final double field12979 = 0.16561;
   private static final double field12980 = 0.49422;
   private static final double field12981 = 4.78;
   private static final double field12982 = 2.0;
   private static final double field12983 = 4.7;
   private static final double field12984 = 3.14;
   private static final double field12985 = 6.28;
   private static final double field12986 = 6.28;
   private static final double field12987 = 0.65594;
   private static final double field12988 = 0.16561;
   private static final double field12989 = 0.32991;
   private static final double field12990 = 4.78;
   private static final double field12991 = 2.0;
   private static final double field12992 = 4.7;
   private static final double field12993 = 0.65594;
   private static final double field12994 = 0.82025;
   private static final double field12995 = 4.78;
   private static final double field12996 = 2.0;
   private static final double field12997 = 4.7;
   private static final String field12998 = "spear";
   private static final double field12999 = 180.0;
   private static final double field13000 = -180.0;
   private static final double field13001 = 2.0;
   private static final double field13002 = -0.2;
   private static final double field13003 = 0.8;
   private static final double field13004 = -0.05;
   private static final double field13005 = -70.0;
   private static final double field13006 = 0.8;
   private static final double field13007 = -8.0;
   private static final double field13008 = 60.0;
   private static final double field13009 = 0.8;
   private static final double field13010 = -30.0;
   private static final double field13011 = -60.0;
   private static final double field13012 = -0.25;
   private static final double field13013 = 6.28;
   private static final String field13014 = "block";
   private static final String field13015 = "crossbow";
   private static final double field13016 = -0.05;
   private static final double field13017 = -0.05;
   private static final double field13018 = 10.0;
   private static final double field13019 = -30.0;
   private static final double field13020 = -10.0;
   private static final String field13021 = "trident";
   private static final String field13022 = "spear";
   private static final double field13023 = -0.1;
   private static final double field13024 = -0.05;
   private static final String field13025 = "spear";
   private static final double field13026 = -0.15;
   private static final double field13027 = -5.0;
   private static final double field13028 = -10.0;
   private static final double field13029 = -15.0;
   private static final String field13030 = "trident";
   private static final double field13031 = -45.0;
   private static final double field13032 = -45.0;
   private static final double field13033 = 0.05;
   private static final double field13034 = 0.3;
   private static final double field13035 = -0.05;
   private static final double field13036 = -0.05;
   private static final double field13037 = -10.0;
   private static final double field13038 = -25.0;
   private static final double field13039 = 0.12;
   private static final double field13040 = 0.05;
   private static final double field13041 = 10.0;
   private static final double field13042 = -30.0;
   private static final double field13043 = 20.0;
   private static final double field13044 = 10.0;
   private static final double field13045 = 3.14;
   private static final double field13046 = -0.1;
   private static final double field13047 = -60.0;
   private static final double field13048 = -30.0;
   private static final String field13049 = "bow";
   private static final double field13050 = -0.065;
   private static final double field13051 = 0.2;
   private static final double field13052 = 180.0;
   private static final double field13053 = -0.15;
   private static final double field13054 = -0.4;
   private static final double field13055 = -0.62;
   private static final double field13056 = -0.07;
   private static final double field13057 = 0.4;
   private static final double field13058 = -70.0;
   private static final double field13059 = 0.2;
   private static final double field13060 = -25.0;
   private static final double field13061 = 2.5;
   private static final double field13062 = -20.0;
   private static final double field13063 = 90.0;
   private static final double field13064 = 0.5;
   private static final double field13065 = -0.13;
   private static final double field13066 = 0.01;
   private static final double field13067 = 15.0;
   private static final double field13068 = 0.01;
   private static final double field13069 = 15.0;
   private static final double field13070 = 0.01;
   private static final double field13071 = 8.0;
   private static final double field13072 = 0.03;
   private static final double field13073 = 2.0;
   private static final double field13074 = 0.25;
   private static final double field13075 = 150.0;
   private static final double field13076 = 150.0;
   private static final double field13077 = -1.0;
   private static final double field13078 = 5.0;
   private static final double field13079 = 0.7;
   private static final double field13080 = 0.7;
   private static final double field13081 = 0.7;
   private static final double field13082 = 0.15;
   private static final double field13083 = -0.05;
   private static final double field13084 = -0.1;
   private static final double field13085 = 1.2;
   private static final double field13086 = 1.2;
   private static final double field13087 = 1.2;
   private static final double field13088 = 2.5;
   private static final double field13089 = -20.0;
   private static final double field13090 = 90.0;
   private static final double field13091 = -0.1;
   private static final double field13092 = 0.4;
   private static final double field13093 = 0.1;
   private static final double field13094 = -1.0;
   private static final double field13095 = -0.1;
   private static final double field13096 = 0.4;
   private static final double field13097 = 0.1;
   private static final double field13098 = 2.5;
   private static final double field13099 = -20.0;
   private static final double field13100 = 90.0;
   private static final double field13101 = 0.4;
   private static final double field13102 = -1.0;
   private static final double field13103 = 0.4;
   private static final double field13104 = 2.5;
   private static final double field13105 = -35.0;
   private static final double field13106 = 90.0;
   private static final double field13107 = 0.55;
   private static final double field13108 = -1.0;
   private static final double field13109 = 0.55;
   private static final double field13110 = -25.0;
   private static final double field13111 = -0.65;
   private static final double field13112 = 2.5;
   private static final double field13113 = -25.0;
   private static final double field13114 = 90.0;
   private static final double field13115 = 0.45;
   private static final double field13116 = -1.0;
   private static final double field13117 = 0.55;
   private static final double field13118 = -0.025;
   private static final double field13119 = -0.025;
   private static final double field13120 = -5.0;
   private static final String field13121 = "none";
   private static final String field13122 = "crossbow";
   private static final double field13123 = 0.2;
   private static final double field13124 = 0.15;
   private static final double field13125 = -20.0;
   private static final double field13126 = 0.3;
   private static final double field13127 = -0.3;
   private static final double field13128 = -20.0;
   private static final double field13129 = 0.05;
   private static final double field13130 = 0.3;
   private static final double field13131 = -0.4;
   private static final String field13132 = "crossbow";
   private static final double field13133 = -0.05;
   private static final double field13134 = 0.2;
   private static final double field13135 = -0.2;
   private static final String field13136 = "crossbow";
   private static final double field13137 = -0.025;
   private static final double field13138 = 0.1;
   private static final double field13139 = -0.2;
   private static final String field13140 = "drink";
   private static final String field13141 = "eat";
   private static final String field13142 = "toot_horn";
   private static final double field13143 = 0.02;
   private static final double field13144 = -0.05;
   private static final String field13145 = "eat";
   private static final String field13146 = "toot_horn";
   private static final double field13147 = -23.0;
   private static final double field13148 = -12.0;
   private static final double field13149 = -50.0;
   private static final String field13150 = "drink";
   private static final double field13151 = 15.0;
   private static final String field13152 = "drink";
   private static final String field13153 = "eat";
   private static final String field13154 = "toot_horn";
   private static final double field13155 = 0.02;
   private static final double field13156 = -0.05;
   private static final String field13157 = "eat";
   private static final String field13158 = "toot_horn";
   private static final double field13159 = -23.0;
   private static final double field13160 = -12.0;
   private static final double field13161 = -50.0;
   private static final String field13162 = "drink";
   private static final double field13163 = 15.0;
   private static final String field13164 = "brush";
   private static final double field13165 = -0.03;
   private static final double field13166 = -30.0;
   private static final double field13167 = 15.0;
   private static final double field13168 = 0.5;
   private static final double field13169 = 4.14;
   private static final String field13170 = "brush";
   private static final double field13171 = -0.03;
   private static final double field13172 = -30.0;
   private static final double field13173 = 15.0;
   private static final double field13174 = 0.5;
   private static final double field13175 = 4.14;
   private static final double field13176 = 0.1;
   private static final double field13177 = 0.25;
   private static final double field13178 = -0.35;
   private static final double field13179 = -10.0;
   private static final double field13180 = -90.0;
   private static final double field13181 = 0.17;
   private static final double field13182 = -35.0;
   private static final double field13183 = 0.3;
   private static final double field13184 = -0.4;
   private static final double field13185 = 0.9;
   private static final double field13186 = 0.9;
   private static final double field13187 = 0.9;
   private static final double field13188 = -0.1;
   private static final double field13189 = 0.06;
   private static final double field13190 = 0.12;
   private static final double field13191 = 0.1;
   private static final double field13192 = 0.05;
   private static final double field13193 = 0.1;
   private static final double field13194 = 0.1;
   private static final double field13195 = 0.3;
   private static final double field13196 = 0.006;
   private static final double field13197 = 0.006;
   private static final double field13198 = -0.09;
   private static final double field13199 = 80.0;
   private static final double field13200 = 5.0;
   private static final double field13201 = 5.0;
   private static final double field13202 = 0.09723;
   private static final double field13203 = 0.60632;
   private static final double field13204 = 3.24;
   private static final double field13205 = 1.65;
   private static final double field13206 = 0.1;
   private static final String field13207 = "trident";
   private static final double field13208 = -10.0;
   private static final double field13209 = 0.62;
   private static final double field13210 = 0.1;
   private static final double field13211 = 255.0;
   private static final String field13212 = "entity.experience_orb.pickup";
   private static final float field13213 = 0.3F;
   private static final double field13214 = -0.07;
   private static final double field13215 = 360.0;
   private static final double field13216 = 1.65;
   private static final double field13217 = 1.65;
   private static final double field13218 = 0.1;
   private static final String field13219 = "entity.context.player.attack.weak";
   private static final float field13220 = 0.3F;
   private static final double field13221 = 360.0;
   private static final double field13222 = 1.65;
   private static final double field13223 = 1.65;
   private static final double field13224 = -0.1;
   private static final double field13225 = 0.25;
   private static final String field13226 = "entity.context.player.attack.weak";
   private static final float field13227 = 0.3F;
   private static final double field13228 = 1.2;
   private static final double field13229 = 1.2;
   private static final double field13230 = -7.0;
   private static final double field13231 = 0.0943;
   private static final double field13232 = 0.66791;
   private static final double field13233 = 7.07;
   private static final double field13234 = 1.5;
   private static final double field13235 = 0.8;
   private static final double field13236 = 5.0;
   private static final double field13237 = -40.0;
   private static final double field13238 = 20.0;
   private static final double field13239 = 15.0;
   private static final double field13240 = -10.0;
   private static final double field13241 = -0.05;
   private static final double field13242 = -0.05;
   private static final double field13243 = -40.0;
   private static final double field13244 = -10.0;
   private static final double field13245 = 5.0;
   private static final String field13246 = "bow";
   private static final String field13247 = "spear";
   private static final double field13248 = -0.05;
   private static final double field13249 = -8.0;
   private static final double field13250 = -10.0;
   private static final double field13251 = 6.0;
   private static final double field13252 = -0.05;
   private static final double field13253 = -8.0;
   private static final double field13254 = -10.0;
   private static final double field13255 = 6.0;
   private static final double field13256 = 0.1;
   private static final double field13257 = 180.0;
   private static final double field13258 = 45.0;
   private static final double field13259 = -0.1;
   private static final double field13260 = 0.11;
   private static final double field13261 = 15.0;
   private static final double field13262 = -85.0;
   private static final double field13263 = -55.0;
   private static final double field13264 = 0.25;
   private static final double field13265 = 6.0;
   private static final double field13266 = 160.0;
   private static final String field13267 = "context.item.armor.equip_leather";
   private static final float field13268 = 0.2F;
   private static final double field13269 = 0.5;
   private static final double field13270 = 0.6;
   private static final double field13271 = 0.5;
   private static final double field13272 = 1.3;
   private static final double field13273 = 200.0;
   private static final double field13274 = 20.0;
   private static final double field13275 = 0.2;
   private static final double field13276 = 0.45;
   private static final double field13277 = 0.15;
   private static final double field13278 = 0.5;
   private static final double field13279 = 1.3;
   private static final double field13280 = 200.0;
   private static final double field13281 = 20.0;
   private static final double field13282 = 0.2;
   private static final String field13283 = "copper";
   private static final double field13284 = 0.45;
   private static final double field13285 = 0.15;
   private static final double field13286 = 0.5;
   private static final double field13287 = 1.3;
   private static final double field13288 = 200.0;
   private static final double field13289 = 20.0;
   private static final double field13290 = 0.2;
   private static final double field13291 = 0.5;
   private static final double field13292 = 0.6;
   private static final double field13293 = 0.5;
   private static final double field13294 = 1.3;
   private static final double field13295 = 110.0;
   private static final double field13296 = 10.0;
   private static final double field13297 = 0.2;
   private static final double field13298 = 0.45;
   private static final double field13299 = 0.15;
   private static final double field13300 = 0.5;
   private static final double field13301 = 1.3;
   private static final double field13302 = 110.0;
   private static final double field13303 = 10.0;
   private static final double field13304 = 0.2;
   private static final double field13305 = 0.5;
   private static final double field13306 = 0.6;
   private static final double field13307 = 0.5;
   private static final double field13308 = 1.3;
   private static final double field13309 = 110.0;
   private static final double field13310 = 10.0;
   private static final double field13311 = 0.2;
   private static final double field13312 = 0.025;
   private static final double field13313 = 30.0;
   private static final String field13314 = "trident";
   private static final double field13315 = -0.2;
   private static final double field13316 = -360.0;
   private static final double field13317 = 0.15;
   private static final String field13318 = "block.bell.use";
   private static final float field13319 = 0.3F;
   private static final String field13320 = "block.leaf_litter.place";
   private static final float field13321 = 0.7F;
   private static final String field13322 = "block.leaf_litter.place";
   private static final float field13323 = 0.7F;
   private static final double field13324 = 0.025;
   private static final double field13325 = -0.1;
   private static final double field13326 = 180.0;
   private static final double field13327 = -82.5;
   private static final double field13328 = -20.0;
   private static final double field13329 = 0.025;
   private static final double field13330 = -0.1;
   private static final double field13331 = 180.0;
   private static final double field13332 = -82.5;
   private static final double field13333 = -20.0;
   private static final double field13334 = 30.0;
   private static final double field13335 = 0.1;
   private static final double field13336 = 0.02;
   private static final double field13337 = -0.05;
   private static final double field13338 = 2.0;
   private static final double field13339 = 150.0;
   private static final double field13340 = 20.0;
   private static final double field13341 = 0.2;
   private static final String field13342 = "bucket_of_frog:frog_bucket_cold";
   private static final String field13343 = "bucket_of_frog:frog_bucket_warm";
   private static final String field13344 = "bucket_of_frog:frog_bucket_temperate";
   private static final double field13345 = 0.025;
   private static final double field13346 = -0.1;
   private static final double field13347 = 180.0;
   private static final double field13348 = -82.5;
   private static final double field13349 = -20.0;
   private static final String field13350 = "trident";
   private static final double field13351 = 1.5;
   private static final double field13352 = 180.0;
   private static final double field13353 = 170.0;
   private static final double field13354 = -0.1;
   private static final double field13355 = 40.0;
   private static final String field13356 = "spear";
   private static final double field13357 = -0.1;
   private static final double field13358 = 10.0;
   private static final String field13359 = "trident";
   private static final double field13360 = -90.0;
   private static final double field13361 = 3.14;
   private static final double field13362 = -45.0;
   private static final double field13363 = 3.14;
   private static final double field13364 = -0.05;
   private static final double field13365 = -0.15;
   private static final double field13366 = 6.0;
   private static final double field13367 = -8.0;
   private static final double field13368 = 25.0;
   private static final double field13369 = 1.1;
   private static final double field13370 = 1.1;
   private static final double field13371 = 1.1;
   private static final double field13372 = 0.1;
   private static final String field13373 = "minecraft:bow";
   private static final String field13374 = "minecraft:bow";
   private static final String field13375 = "minecraft:bow";
   private static final double field13376 = 20.0;
   private static final String field13377 = "orange_glow";
   private static final String field13378 = "blue_glow";
   private static final String field13379 = "red_glow";
   private static final String field13380 = "firefly";
   private static final String field13381 = "pink_petals_1";
   private static final String field13382 = "pink_petals_2";
   private static final String field13383 = "pink_petals_4";
   private static final String field13384 = "wild_flowers_1";
   private static final String field13385 = "wild_flowers_2";
   private static final String field13386 = "wild_flowers_4";
   private static final String field13387 = "leaf_litter_1";
   private static final String field13388 = "leaf_litter_2";
   private static final String field13389 = "leaf_litter_4";
   private static final String field13390 = "minecraft:string";
   private static final String field13391 = "minecraft:resin_clump";
   private static final String field13392 = "minecraft:vine";
   private static final String field13393 = "minecraft:kelp";
   private static final String field13394 = "minecraft:seagrass";
   private static final String field13395 = "minecraft:iron_bars";
   private static final String field13396 = "minecraft:glass_pane";
   private static final String field13397 = "minecraft:white_stained_glass_pane";
   private static final String field13398 = "minecraft:orange_stained_glass_pane";
   private static final String field13399 = "minecraft:magenta_stained_glass_pane";
   private static final String field13400 = "minecraft:light_blue_stained_glass_pane";
   private static final String field13401 = "minecraft:yellow_stained_glass_pane";
   private static final String field13402 = "minecraft:lime_stained_glass_pane";
   private static final String field13403 = "minecraft:pink_stained_glass_pane";
   private static final String field13404 = "minecraft:gray_stained_glass_pane";
   private static final String field13405 = "minecraft:light_gray_stained_glass_pane";
   private static final String field13406 = "minecraft:cyan_stained_glass_pane";
   private static final String field13407 = "minecraft:purple_stained_glass_pane";
   private static final String field13408 = "minecraft:blue_stained_glass_pane";
   private static final String field13409 = "minecraft:brown_stained_glass_pane";
   private static final String field13410 = "minecraft:green_stained_glass_pane";
   private static final String field13411 = "minecraft:red_stained_glass_pane";
   private static final String field13412 = "minecraft:black_stained_glass_pane";
   private static final String field13413 = "minecraft:ladder";
   private static final String field13414 = "minecraft:oak_sign";
   private static final String field13415 = "minecraft:spruce_sign";
   private static final String field13416 = "minecraft:birch_sign";
   private static final String field13417 = "minecraft:jungle_sign";
   private static final String field13418 = "minecraft:acacia_sign";
   private static final String field13419 = "minecraft:dark_oak_sign";
   private static final String field13420 = "minecraft:mangrove_sign";
   private static final String field13421 = "minecraft:cherry_sign";
   private static final String field13422 = "minecraft:bamboo_sign";
   private static final String field13423 = "minecraft:crimson_sign";
   private static final String field13424 = "minecraft:warped_sign";
   private static final String field13425 = "minecraft:pale_oak_sign";
   private static final String field13426 = "minecraft:tripwire_hook";
   private static final String field13427 = "minecraft:hopper";
   private static final String field13428 = "minecraft:cauldron";
   private static final String field13429 = "minecraft:rail";
   private static final String field13430 = "minecraft:powered_rail";
   private static final String field13431 = "minecraft:detector_rail";
   private static final String field13432 = "minecraft:activator_rail";
   private static final String field13433 = "minecraft:repeater";
   private static final String field13434 = "minecraft:comparator";
   private static final String field13435 = "minecraft:twisting_vines";
   private static final String field13436 = "minecraft:weeping_vines";
   private static final String field13437 = "minecraft:sniffer_egg";
   private static final String field13438 = "minecraft:candle";
   private static final String field13439 = "minecraft:white_candle";
   private static final String field13440 = "minecraft:orange_candle";
   private static final String field13441 = "minecraft:magenta_candle";
   private static final String field13442 = "minecraft:light_blue_candle";
   private static final String field13443 = "minecraft:yellow_candle";
   private static final String field13444 = "minecraft:lime_candle";
   private static final String field13445 = "minecraft:pink_candle";
   private static final String field13446 = "minecraft:gray_candle";
   private static final String field13447 = "minecraft:light_gray_candle";
   private static final String field13448 = "minecraft:cyan_candle";
   private static final String field13449 = "minecraft:purple_candle";
   private static final String field13450 = "minecraft:blue_candle";
   private static final String field13451 = "minecraft:brown_candle";
   private static final String field13452 = "minecraft:green_candle";
   private static final String field13453 = "minecraft:red_candle";
   private static final String field13454 = "minecraft:black_candle";
   private static final String field13455 = "minecraft:frogspawn";
   private static final String field13456 = "minecraft:light";
   private static final String field13457 = "minecraft:structure_void";
   private static final String field13458 = "minecraft:barrier";
   private static final String field13459 = "minecraft:carrot";
   private static final String field13460 = "minecraft:powder_snow_bucket";
   private static final String field13461 = "minecraft:glow_berries";
   private static final String field13462 = "minecraft:potato";
   private static final String field13463 = "minecraft:sweet_berries";
   private static final String field13464 = "minecraft:redstone";
   private static final String field13465 = "minecraft:string";
   private static final String field13466 = "minecraft:resin_clump";
   private static final String field13467 = "minecraft:vine";
   private static final String field13468 = "minecraft:bamboo";
   private static final String field13469 = "bamboo";
   private static final String field13470 = "minecraft:trident";
   private static final String field13471 = "minecraft:iron_spear";
   private static final String field13472 = "minecraft:copper_spear";
   private static final String field13473 = "minecraft:diamond_spear";
   private static final String field13474 = "minecraft:wooden_spear";
   private static final String field13475 = "minecraft:stone_spear";
   private static final String field13476 = "minecraft:golden_spear";
   private static final String field13477 = "minecraft:netherite_spear";
   private static final String field13478 = "minecraft:mace";

   private static void method05960(ItemAnimationContext var0, double var1, Identifier var3, Identifier var4, Identifier var5) {
      ParticleKeyframe.method04810(
         var0.field19861,
         true,
         field12762 * var1,
         field12763,
         field12764,
         (Math.random() * field12765 - field12766) * var1,
         Math.random() * field12767,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         field12768,
         field12747,
         field12769,
         var0.field19841,
         field12770,
         field12771,
         1.0,
         field12772
      );
      ParticleKeyframe.method04810(
         var0.field19861,
         true,
         field12773 * var1,
         field12774,
         field12775,
         (Math.random() * field12776 - field12777) * var1,
         Math.random() * field12778,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         field12779,
         field12747,
         field12780,
         var0.field19841,
         field12781,
         field12782,
         1.0,
         field12783
      );
      ParticleKeyframe.method04810(
         var0.field19861,
         true,
         field12784 * var1,
         field12785,
         field12786,
         (Math.random() * field12787 - field12788) * var1,
         Math.random() * field12789,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         field12790,
         var3,
         field12791,
         var0.field19841,
         field12792,
         field12793,
         1.0,
         field12794
      );
      ParticleKeyframe.method04810(
         var0.field19861,
         true,
         field12795 * var1,
         field12796,
         field12797,
         (Math.random() * field12798 - field12799) * var1,
         Math.random() * field12800,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         field12801,
         var3,
         field12802,
         var0.field19841,
         field12803,
         field12804,
         1.0,
         field12805
      );
      ParticleKeyframe.method04810(
         var0.field19861,
         true,
         field12806 * var1,
         field12807,
         field12808,
         (Math.random() * field12809 - field12810) * var1,
         Math.random() * field12811,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         field12812,
         var4,
         field12813,
         var0.field19841,
         field12814,
         field12815,
         1.0,
         field12816
      );
      ParticleKeyframe.method04810(
         var0.field19861,
         true,
         field12817 * var1,
         field12818,
         field12819,
         (Math.random() * field12820 - field12821) * var1,
         Math.random() * field12822,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         field12823,
         var4,
         field12824,
         var0.field19841,
         field12825,
         field12826,
         1.0,
         field12827
      );
      ParticleKeyframe.method04810(
         var0.field19861,
         true,
         field12828 * var1,
         field12829,
         field12830,
         (Math.random() * field12831 - field12832) * var1,
         Math.random() * field12833,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         field12834,
         var5,
         field12835,
         var0.field19841,
         field12836,
         field12837,
         1.0,
         field12838
      );
      ParticleKeyframe.method04810(
         var0.field19861,
         true,
         field12839 * var1,
         field12840,
         field12841,
         (Math.random() * field12842 - field12843) * var1,
         Math.random() * field12844,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         field12845,
         var5,
         field12846,
         var0.field19841,
         field12847,
         field12848,
         1.0,
         field12849
      );
   }

   static {
      ItemFeatureVariables var0 = ItemFeatureVariables.field24990;
      var0.field25110.put(field13465, false);
      var0.field25110.put(field13466, false);
      var0.field25110.put(field13467, false);
      var0.field25110.put(field13468, false);

      for (String var4 : field12757) {
         var0.field25110.put(var4, false);
         if (!var4.equals(field13469)) {
            var0.field25111.put(var4, true);
         }
      }

      var0.field25114.put(field13470, 12);
      var0.field25114.put(field13471, 15);
      var0.field25114.put(field13472, 15);
      var0.field25114.put(field13473, 15);
      var0.field25114.put(field13474, 15);
      var0.field25114.put(field13475, 15);
      var0.field25114.put(field13476, 15);
      var0.field25114.put(field13477, 15);
      var0.field25114.put(field13478, 12);
   }

   private static void method05961(ItemAnimationContext var0, double var1, double var3, double var5, double var7, Identifier var9, double var10) {
      ParticleKeyframe.method04810(
         var0.field19861,
         false,
         var1,
         var3,
         var5,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         0.0,
         var7,
         var9,
         field12759,
         var0.field19841,
         field12760,
         field12761,
         0.0,
         var10
      );
   }

   private ParticleConfigCodec() {
   }

   private static Identifier method05962(String var0) {
      return Identifier.fromNamespaceAndPath(field12758, "textures/particle/" + var0 + ".png");
   }

   public static void method05963(ItemAnimationContext var0) {
      ItemFeatureVariables var1 = ItemFeatureVariables.field24990;
      AbstractClientPlayer var2 = var0.field19837;
      if (var2 != null) {
         PoseStack var3 = var0.field19839;
         String var4 = ItemFeatureProperties.method05406(var0.field19838);
         double var5 = var0.field19843 ? 1.0 : field12850;
         ItemStack var7 = var0.field19838;
         String var8 = ItemFeatureProperties.method05412(var7);
         boolean var9 = ItemFeatureProperties.method05409(var7);
         boolean var10 = ItemFeatureProperties.method05408(var7);
         boolean var11 = ItemFeatureProperties.method05420(var7, ItemTagAliases.field23895);
         boolean var12 = ItemFeatureProperties.method05420(var7, ItemTagAliases.field23894);
         boolean var13 = ItemFeatureProperties.method05420(var7, ItemTagAliases.field23896);
         boolean var14 = ItemFeatureProperties.method05420(var7, ItemTagAliases.field23897);
         boolean var15 = ItemFeatureProperties.method05420(var7, ItemTagAliases.field23901);
         boolean var16 = ItemFeatureProperties.method05420(var7, ItemTagAliases.field23898);
         var1.field25087 = var1.field25087 + ItemAnimationMath.method00526(var1.field25054 * field12851) * var1.field25021 * var0.field19847 * field12852;
         var1.field25087 = var1.field25087 - field12853 * var1.field25089 * var0.field19847 * field12854;
         var1.field25087 = var1.field25087 * ItemAnimationMath.method00519(field12855, var0.field19847 * field12856);
         var1.field25089 = var1.field25089 + var1.field25087 * var0.field19847 * field12857;
         var1.field25088 = var1.field25088 + ItemAnimationMath.method00526(var1.field25056 * field12858) * var1.field25022 * var0.field19847 * field12859;
         var1.field25088 = var1.field25088 - field12860 * var1.field25090 * var0.field19847 * field12861;
         var1.field25088 = var1.field25088 * ItemAnimationMath.method00519(field12862, var0.field19847 * field12863);
         var1.field25090 = var1.field25090 + var1.field25088 * var0.field19847 * field12864;
         double var17 = ItemFeatureProperties.method05406(PlayerAnimationUtils.method09056(var2)).equals(field12865) ? 1.0 : 0.0;
         double var19 = ItemFeatureProperties.method05406(PlayerAnimationUtils.method09055(var2)).equals(field12866) ? 1.0 : 0.0;
         double var21 = var0.field19842 ? var1.field25065 : var1.field25069;
         double var23 = var0.field19842 ? var1.field25067 : var1.field25070;
         double var25 = var0.field19842 ? var1.field25068 : var1.field25071;
         double var27 = var0.field19842 ? var1.field25060 : var1.field25061;
         double var29 = var0.field19842 ? AnimationCurveMath.method08361(var1.field25072) : var1.field25073;
         var1.field25081 = var1.field25081
            + (
                  PlayerAnimationUtils.method09042(var2) * field12867 * var1.field25041 * field12868
                     - ItemAnimationMath.method00526(var0.field19851 * field12869) * field12870
                     + var1.field25042 * field12871
                     + ItemAnimationMath.method00526(var1.field25044 * field12872) * field12873
                     + (PlayerAnimationUtils.method09053(var2) - var1.field25080)
               )
               * field12874
               * var0.field19847
               * field12875;
         if (var4.equals(field12876) && var0.field19842 && !var11) {
            var1.field25081 = var1.field25081
               + field12877 * ItemAnimationMath.method00526(var1.field25015 * field12878) * field12879 * var0.field19847 * field12880;
            var1.field25081 = var1.field25081
               + field12881 * ItemAnimationMath.method00526(var1.field25038 * field12882) * field12883 * var0.field19847 * field12884;
         }

         var1.field25081 = var1.field25081
            + (
                  field12885 * ItemAnimationMath.method00526(var1.field25067 * field12886) * var1.field25065
                     + field12887 * ItemAnimationMath.method00526(var1.field25068 * field12888) * var1.field25065
                     + field12889 * ItemAnimationMath.method00526(var1.field25010 * field12890)
                     + field12891 * ItemAnimationMath.method00526(var1.field25065 * field12892)
                     + field12893
                        * ItemAnimationMath.method00520(ItemAnimationMath.method00526(AnimationCurveMath.method08362(var1.field25072) * field12894), 0.0, 1.0)
                     + field12895
                        * ItemAnimationMath.method00520(
                           ItemAnimationMath.method00526(ItemAnimationMath.method00520(var1.field25060 * field12896 * var17, 0.0, 1.0) * field12897),
                           0.0,
                           1.0
                        )
               )
               * field12898
               * var0.field19847
               * field12899;
         var1.field25081 = var1.field25081 - field12900 * var1.field25019 * var0.field19847 * field12901;
         var1.field25081 = var1.field25081 * ItemAnimationMath.method00519(field12902, var0.field19847 * field12903);
         var1.field25019 = var1.field25019 + var1.field25081 * var0.field19847 * field12904;
         var1.field25085 = var1.field25085
            + (
                  ItemAnimationMath.method00526(var1.field25040) * field12905 * var1.field25041
                     + ItemAnimationMath.method00526(var0.field19851 * field12906) * field12907
                     + ItemAnimationMath.method00526(var1.field25062 * var1.field25025) * field12908
                     + ItemAnimationMath.method00526(var1.field25060 * field12909) * field12910
                     + PlayerAnimationUtils.method09051(var2)
                     - var1.field25084
               )
               * field12911
               * var0.field19847
               * field12912;
         var1.field25085 = var1.field25085 - field12913 * var1.field25020 * var0.field19847 * field12914;
         var1.field25085 = var1.field25085 * ItemAnimationMath.method00519(field12915, var0.field19847 * field12916);
         var1.field25020 = var1.field25020 + var1.field25085 * var0.field19847 * field12917;
         var1.field25082 = var1.field25082
            + (
                  PlayerAnimationUtils.method09042(var2) * field12918 * var1.field25041 * field12919
                     - ItemAnimationMath.method00526(var0.field19852 * field12920) * field12921
                     + var1.field25042 * field12922
                     + ItemAnimationMath.method00526(var1.field25044 * field12923) * field12924
                     + (PlayerAnimationUtils.method09053(var2) - var1.field25080)
               )
               * field12925
               * var0.field19847
               * field12926;
         if (var4.equals(field12927) && !var0.field19842 && !var11) {
            var1.field25082 = var1.field25082
               + field12928 * ItemAnimationMath.method00526(var1.field25015 * field12929) * field12930 * var0.field19847 * field12931;
            var1.field25082 = var1.field25082
               + field12932 * ItemAnimationMath.method00526(var1.field25039 * field12933) * field12934 * var0.field19847 * field12935;
         }

         var1.field25082 = var1.field25082
            + (
                  field12936 * ItemAnimationMath.method00526(var1.field25070 * field12937) * var1.field25069
                     + field12938 * ItemAnimationMath.method00526(var1.field25071 * field12939) * var1.field25069
                     + field12940 * ItemAnimationMath.method00526(var1.field25069 * field12941)
                     + field12942
                        * ItemAnimationMath.method00520(
                           ItemAnimationMath.method00526(ItemAnimationMath.method00520(var1.field25061 * field12943 * var19, 0.0, 1.0) * field12944),
                           0.0,
                           1.0
                        )
               )
               * field12945
               * var0.field19847
               * field12946;
         var1.field25082 = var1.field25082 - field12947 * var1.field25017 * var0.field19847 * field12948;
         var1.field25082 = var1.field25082 * ItemAnimationMath.method00519(field12949, var0.field19847 * field12950);
         var1.field25017 = var1.field25017 + var1.field25082 * var0.field19847 * field12951;
         var1.field25083 = var1.field25083
            + (
                  ItemAnimationMath.method00526(var1.field25040) * field12952 * var1.field25041
                     + ItemAnimationMath.method00526(var0.field19852 * field12953) * field12954
                     + ItemAnimationMath.method00526(var1.field25062 * var1.field25025) * field12955
                     + ItemAnimationMath.method00526(var1.field25061 * field12956) * field12957
                     + PlayerAnimationUtils.method09051(var2)
                     - var1.field25084
               )
               * field12958
               * var0.field19847
               * field12959;
         var1.field25083 = var1.field25083 - field12960 * var1.field25018 * var0.field19847 * field12961;
         var1.field25083 = var1.field25083 * ItemAnimationMath.method00519(field12962, var0.field19847 * field12963);
         var1.field25018 = var1.field25018 + var1.field25083 * var0.field19847 * field12964;
         double var31 = var0.field19842 ? var1.field25020 : var1.field25018;
         double var33 = var0.field19842 ? var1.field25019 : var1.field25017;
         if (var12) {
            var0.field19845 = (float)ItemAnimationCurves.method02441(var0.field19845);
         } else {
            var0.field19845 = (float)ItemAnimationCurves.method02442(var0.field19845);
         }

         double var35;
         if (var0.field19845 < field12965) {
            var35 = ItemAnimationMath.method00526(ItemAnimationMath.method00520(var0.field19845, 0.0, field12966) * field12967);
         } else {
            var35 = ItemAnimationMath.method00526(ItemAnimationMath.method00520(var0.field19845, field12968, 1.0) * field12969 - field12970);
         }

         double var37;
         if (var0.field19845 < field12971) {
            var37 = ItemAnimationMath.method00526(ItemAnimationMath.method00520(var0.field19845, 0.0, field12972) * field12973 * field12974);
         } else {
            var37 = ItemAnimationMath.method00526(ItemAnimationMath.method00520(var0.field19845, field12975, 1.0) * field12976 - field12977);
         }

         var35 = var35 * var35 * var35;
         double var39 = ItemAnimationMath.method00520(ItemAnimationMath.method00526(var0.field19845 * field12978), 0.0, 1.0);
         double var41 = ItemAnimationMath.method00526(
            ItemAnimationMath.method00520(var0.field19845, field12979, field12980) * field12981 * field12982 + field12983
         );
         double var43 = ItemAnimationMath.method00526(var0.field19845 * field12984);
         double var45 = ItemAnimationMath.method00520(ItemAnimationMath.method00526(var0.field19845 * field12985), 0.0, 1.0);
         double var47 = ItemAnimationMath.method00526(var0.field19845 * field12986);
         double var49;
         if (var0.field19845 < field12987) {
            var49 = ItemAnimationMath.method00526(
               ItemAnimationMath.method00520(var0.field19845, field12988, field12989) * field12990 * field12991 + field12992
            );
         } else {
            var49 = ItemAnimationMath.method00526(
               ItemAnimationMath.method00520(var0.field19845, field12993, field12994) * field12995 * field12996 - field12997
            );
         }

         if (var4.equals(field12998)) {
            ItemAnimationMath.method00524(var3, field12999 * var5);
            ItemAnimationMath.method00524(
               var3, field13000 * AnimationCurveMath.method08367(ItemAnimationMath.method00520(var27 * field13001, 0.0, 1.0)) * var5
            );
            ItemAnimationMath.method00517(var3, field13002 * AnimationCurveMath.method08361(AnimationCurveMath.method08367(var21 * field13003)));
            ItemAnimationMath.method00527(var3, field13004 * AnimationCurveMath.method08367(var23));
            ItemAnimationMath.method00513(var3, field13005 * AnimationCurveMath.method08367(var21 * field13006));
            ItemAnimationMath.method00513(var3, field13007 * AnimationCurveMath.method08367(var23));
            ItemAnimationMath.method00512(var3, field13008 * AnimationCurveMath.method08367(var21 * field13009) * var5);
            ItemAnimationMath.method00512(var3, field13010 * AnimationCurveMath.method08367(var23) * var5);
            ItemAnimationMath.method00512(var3, field13011 * AnimationCurveMath.method08375(var25) * var25 * var5);
            ItemAnimationMath.method00527(
               var3, field13012 * ItemAnimationMath.method00520(ItemAnimationMath.method00526(AnimationCurveMath.method08361(var29) * field13013), 0.0, 1.0)
            );
         }

         if (!var4.equals(field13014) && !var4.equals(field13015) || var11) {
            ItemAnimationMath.method00517(var3, field13016 * var35);
            ItemAnimationMath.method00527(var3, field13017 * var35);
            ItemAnimationMath.method00513(var3, field13018 * var35);
            ItemAnimationMath.method00513(var3, field13019 * var35);
            ItemAnimationMath.method00513(var3, field13020 * var41);
            if (!var11) {
               if (!var4.equals(field13021) && !var4.equals(field13022)) {
                  ItemAnimationMath.method00517(var3, field13035 * var35);
                  ItemAnimationMath.method00527(var3, field13036 * var35);
                  ItemAnimationMath.method00513(var3, field13037 * var35);
                  ItemAnimationMath.method00513(var3, field13038 * var41);
               } else {
                  ItemAnimationMath.method00517(var3, field13023 * var35);
                  ItemAnimationMath.method00527(var3, field13024 * var35);
                  if (var4.equals(field13025)) {
                     ItemAnimationMath.method00527(var3, field13026 * var41);
                     ItemAnimationMath.method00513(var3, field13027 * var41);
                  }

                  ItemAnimationMath.method00513(var3, field13028 * var35);
                  ItemAnimationMath.method00513(var3, field13029 * var41);
                  if (var4.equals(field13030)) {
                     ItemAnimationMath.method00513(var3, field13031 * var43);
                  } else {
                     ItemAnimationMath.method00513(var3, field13032 * var37);
                  }

                  ItemAnimationMath.method00527(var3, field13033 * var41);
                  ItemAnimationMath.method00527(var3, field13034 * var43);
               }
            }

            if (var14) {
               ItemAnimationMath.method00527(var3, field13039 * var37);
               ItemAnimationMath.method00517(var3, field13040 * var37);
               ItemAnimationMath.method00513(var3, field13041 * var37);
               ItemAnimationMath.method00513(var3, field13042 * var43);
               ItemAnimationMath.method00513(var3, field13043 * var35);
               ItemAnimationMath.method00513(var3, field13044 * var49);
            }

            if (var11) {
               var39 = ItemAnimationMath.method00526(var0.field19845 * field13045);
               ItemAnimationMath.method00527(var3, field13046 * AnimationCurveMath.method08367(var39));
               if (var11) {
                  ItemAnimationMath.method00513(var3, field13047 * AnimationCurveMath.method08367(var39));
               } else {
                  ItemAnimationMath.method00513(var3, field13048 * AnimationCurveMath.method08367(var39));
               }
            }

            if (var4.equals(field13049)) {
               ItemAnimationMath.method00529(var3, field13050 * var5);
            }
         }

         if (ItemFeatureProperties.method05420(var0.field19838, ItemTagAliases.field23903)) {
            ItemAnimationMath.method00517(var3, field13051);
            ItemAnimationMath.method00508(var3, field13052 * var5, field13053 * var5, field13054, 0.0);
         }

         if (!ItemFeatureProperties.method05404(var0.field19838, Items.BELL)
            && !var10
            && !ItemFeatureProperties.method05404(var0.field19838, Items.END_CRYSTAL)
            && !var16
            && !ItemFeatureProperties.method05404(var0.field19838, Items.PINK_PETALS)
            && !ItemFeatureProperties.method05404(var0.field19838, Items.LEAF_LITTER)
            && !ItemFeatureProperties.method05404(var0.field19838, Items.WILDFLOWERS)) {
            if (ItemFeatureProperties.method05404(var0.field19838, Items.PAINTING) || ItemFeatureProperties.method05404(var0.field19838, Items.ITEM_FRAME)) {
               var0.field19845 = 0.0F;
               ItemAnimationMath.method00513(var3, field13110);
               ItemAnimationMath.method00527(var3, field13111);
               ItemAnimationMath.method00511(
                  var3, ItemAnimationMath.method00520(PlayerAnimationUtils.method09053(var2) / field13112, field13113, field13114) + var33, 0.0, field13115, 0.0
               );
               ItemAnimationMath.method00509(var3, var31 * field13116, 0.0, field13117, 0.0);
            } else if (var9) {
               ItemAnimationMath.method00527(var3, field13118);
               ItemAnimationMath.method00517(var3, field13119);
               ItemAnimationMath.method00513(var3, field13120);
            } else {
               if (!var9 && !ItemFeatureProperties.method05419(var0.field19838) && var4.equals(field13121) && !var4.equals(field13122)) {
                  if (!var13 && !ItemFeatureProperties.method05404(var0.field19838, Items.MACE)) {
                     ItemAnimationMath.method00511(
                        var3,
                        field13128 * ItemAnimationMath.method00526(var0.field19846 * var0.field19846 * var0.field19846) + var33 * field13129,
                        field13130 * var5,
                        field13131,
                        0.0
                     );
                  } else {
                     double var51 = ItemFeatureProperties.method05404(var0.field19838, Items.MACE) ? field13123 : field13124;
                     ItemAnimationMath.method00511(
                        var3,
                        field13125 * ItemAnimationMath.method00526(var0.field19846 * var0.field19846 * var0.field19846) + var33 * var51,
                        field13126 * var5,
                        field13127,
                        0.0
                     );
                  }
               }

               if ((var13 || ItemFeatureProperties.method05404(var0.field19838, Items.MACE)) && !var4.equals(field13132)) {
                  ItemAnimationMath.method00511(var3, PlayerAnimationUtils.method09053(var2) * field13133 + var33 * field13134, 0.0, field13135, 0.0);
               } else if (!var4.equals(field13136)) {
                  ItemAnimationMath.method00511(var3, PlayerAnimationUtils.method09053(var2) * field13137 + var33 * field13138, 0.0, field13139, 0.0);
               }
            }
         } else {
            if (!ItemFeatureProperties.method05404(var0.field19838, Items.END_CRYSTAL)) {
               ItemAnimationMath.method00527(var3, field13055);
            }

            if (var16) {
               ItemAnimationMath.method00527(var3, field13056);
            }

            if (!ItemFeatureProperties.method05404(var0.field19838, Items.PINK_PETALS)
               && !ItemFeatureProperties.method05404(var0.field19838, Items.LEAF_LITTER)
               && !ItemFeatureProperties.method05404(var0.field19838, Items.WILDFLOWERS)) {
               ItemAnimationMath.method00517(var3, field13059);
               ItemAnimationMath.method00513(var3, field13060);
            } else {
               ItemAnimationMath.method00527(var3, field13057);
               ItemAnimationMath.method00513(var3, field13058);
            }

            if (ItemFeatureProperties.method05404(var0.field19838, Items.PINK_PETALS)
               || ItemFeatureProperties.method05404(var0.field19838, Items.WILDFLOWERS)
               || ItemFeatureProperties.method05404(var0.field19838, Items.LEAF_LITTER)) {
               ItemAnimationMath.method00511(
                  var3,
                  ItemAnimationMath.method00520(PlayerAnimationUtils.method09053(var2) / field13061, field13062, field13063) + var33 + var31 * field13064,
                  0.0,
                  field13065,
                  0.0
               );
            }

            if (ItemFeatureProperties.method05404(var0.field19838, Items.BELL) || var10 || ItemFeatureProperties.method05404(var0.field19838, Items.END_CRYSTAL)) {
               if (ItemFeatureProperties.method05404(var0.field19838, Items.END_CRYSTAL)) {
                  ItemAnimationMath.method00516(
                     var3,
                     1.0 + field13066 * ItemAnimationMath.method00526(var1.field25045 * field13067),
                     1.0 + field13068 * ItemAnimationMath.method00526(var1.field25045 * field13069),
                     1.0 + field13070 * ItemAnimationMath.method00526(var1.field25045 * field13071)
                  );
                  ItemAnimationMath.method00527(var3, field13072 * ItemAnimationMath.method00526(var1.field25045 * field13073));
                  ItemAnimationMath.method00527(var3, field13074);
                  ItemAnimationMath.method00527(var3, var33 / field13075);
                  ItemAnimationMath.method00529(var3, var31 / field13076 * var5 * field13077);
                  ItemAnimationMath.method00524(var3, field13078 * ItemAnimationMath.method00526(var1.field25045));
                  ItemAnimationMath.method00516(var3, field13079, field13080, field13081);
               } else if (ItemFeatureProperties.method05404(var0.field19838, Items.BELL)) {
                  ItemAnimationMath.method00529(var3, field13082 * var5);
                  ItemAnimationMath.method00527(var3, field13083);
                  ItemAnimationMath.method00517(var3, field13084);
                  ItemAnimationMath.method00516(var3, field13085, field13086, field13087);
                  ItemAnimationMath.method00511(
                     var3,
                     ItemAnimationMath.method00520(PlayerAnimationUtils.method09053(var2) / field13088, field13089, field13090) + var33,
                     field13091 * var5,
                     field13092,
                     field13093
                  );
                  ItemAnimationMath.method00509(var3, var31 * field13094, field13095 * var5, field13096, field13097);
               } else {
                  ItemAnimationMath.method00511(
                     var3,
                     ItemAnimationMath.method00520(PlayerAnimationUtils.method09053(var2) / field13098, field13099, field13100) + var33,
                     0.0,
                     field13101,
                     0.0
                  );
                  ItemAnimationMath.method00509(var3, var31 * field13102, 0.0, field13103, 0.0);
               }
            }

            if (var16) {
               ItemAnimationMath.method00511(
                  var3, ItemAnimationMath.method00520(PlayerAnimationUtils.method09053(var2) / field13104, field13105, field13106) + var33, 0.0, field13107, 0.0
               );
               ItemAnimationMath.method00509(var3, var31 * field13108, 0.0, field13109, 0.0);
            }
         }

         if ((var4.equals(field13140) || var4.equals(field13141) || var4.equals(field13142)) && var0.field19842) {
            ItemAnimationMath.method00529(var3, field13143 * var5 * var1.field25053);
            ItemAnimationMath.method00517(var3, field13144 * var1.field25053);
            if (var4.equals(field13145) || var4.equals(field13146)) {
               ItemAnimationMath.method00513(var3, field13147 * var1.field25053 * var1.field25053);
               ItemAnimationMath.method00524(var3, field13148 * var5 * var1.field25053 * var1.field25053);
            }

            ItemAnimationMath.method00512(var3, field13149 * var5 * var1.field25053 * var1.field25053);
            if (var4.equals(field13150)) {
               ItemAnimationMath.method00513(var3, field13151 * var1.field25053 * var1.field25053);
            }
         }

         if ((var4.equals(field13152) || var4.equals(field13153) || var4.equals(field13154)) && !var0.field19842) {
            ItemAnimationMath.method00529(var3, field13155 * var5 * var1.field25055);
            ItemAnimationMath.method00517(var3, field13156 * var1.field25055);
            if (var4.equals(field13157) || var4.equals(field13158)) {
               ItemAnimationMath.method00513(var3, field13159 * var1.field25055 * var1.field25055);
               ItemAnimationMath.method00524(var3, field13160 * var5 * var1.field25055 * var1.field25055);
            }

            ItemAnimationMath.method00512(var3, field13161 * var5 * var1.field25055 * var1.field25055);
            if (var4.equals(field13162)) {
               ItemAnimationMath.method00513(var3, field13163 * var1.field25055 * var1.field25055);
            }
         }

         if (var4.equals(field13164) && var0.field19842) {
            ItemAnimationMath.method00517(var3, field13165 * AnimationCurveMath.method08367(var1.field25021));
            ItemAnimationMath.method00513(var3, field13166 * AnimationCurveMath.method08367(var1.field25021));
            ItemAnimationMath.method00524(
               var3,
               field13167
                  * var5
                  * ItemAnimationMath.method00526((var1.field25054 - field13168) * field13169)
                  * AnimationCurveMath.method08367(var1.field25021)
            );
            ItemAnimationMath.method00524(var3, var5 * var1.field25089);
         }

         if (var4.equals(field13170) && !var0.field19842) {
            ItemAnimationMath.method00517(var3, field13171 * AnimationCurveMath.method08367(var1.field25022));
            ItemAnimationMath.method00513(var3, field13172 * AnimationCurveMath.method08367(var1.field25022));
            ItemAnimationMath.method00524(
               var3,
               field13173
                  * var5
                  * ItemAnimationMath.method00526((var1.field25056 - field13174) * field13175)
                  * AnimationCurveMath.method08367(var1.field25022)
            );
            ItemAnimationMath.method00524(var3, var5 * var1.field25090);
         }

         if (ItemFeatureProperties.method05420(var0.field19838, ItemTagAliases.field23900)) {
            ItemAnimationMath.method00529(var3, field13176 * var5);
            ItemAnimationMath.method00517(var3, field13177);
            ItemAnimationMath.method00527(var3, field13178);
            ItemAnimationMath.method00524(var3, field13179 * var5);
            ItemAnimationMath.method00512(var3, field13180 * var5);
         } else if (ItemFeatureProperties.method05420(var0.field19838, ItemTagAliases.field23903)) {
            ItemAnimationMath.method00517(var3, field13181);
            ItemAnimationMath.method00508(var3, field13182 * var5, field13183 * var5, field13184, 0.0);
            ItemAnimationMath.method00516(var3, field13185, field13186, field13187);
         }

         if (ItemFeatureProperties.method05404(var0.field19838, Items.SLIME_BALL)
            || ItemFeatureProperties.method05404(var0.field19838, Items.SLIME_BLOCK)
            || ItemFeatureProperties.method05404(var0.field19838, Items.HONEY_BLOCK)) {
            if (ItemFeatureProperties.method05404(var0.field19838, Items.SLIME_BALL)) {
               ItemAnimationMath.method00527(var3, field13188);
               double var68 = var1.field25042 < 0.0 ? var1.field25042 * field13189 : var1.field25042 * field13190;
               ItemAnimationMath.method00516(var3, 1.0, 1.0 + var68, 1.0);
               ItemAnimationMath.method00527(var3, field13191);
            } else {
               double var69 = var1.field25042 < 0.0 ? var1.field25042 * field13192 : var1.field25042 * field13193;
               double var53 = var1.field25042 < 0.0 ? var1.field25042 * field13194 : var1.field25042 * field13195;
               ItemAnimationMath.method00527(var3, 0.0);
               ItemAnimationMath.method00516(var3, 1.0 - var69, 1.0 + var53, 1.0 - var69);
               ItemAnimationMath.method00527(var3, 0.0);
               if (var0.field19843) {
                  ItemAnimationMath.method00515(var3, 0.0, 0.0 - var31 * field13196, 0.0);
               } else {
                  ItemAnimationMath.method00515(var3, 0.0, 0.0 + var31 * field13197, 0.0);
               }
            }
         }

         if (var14) {
            ItemAnimationMath.method00529(var3, field13198 * var5);
            ItemAnimationMath.method00512(var3, field13199 * var5);
         }

         var1.field25080 = PlayerAnimationUtils.method09053(var2);
         var1.field25084 = PlayerAnimationUtils.method09051(var2);
         if (ItemFeatureProperties.method05404(var0.field19838, Items.MAGMA_CREAM)) {
            ItemAnimationMath.method00516(var3, 1.0 - var1.field25042 / field13200, 1.0 + var1.field25042 / field13201, 1.0);
         }

         double var70 = AnimationCurveMath.method08362(
            ItemAnimationMath.method00526(
               ItemAnimationMath.method00520(var0.field19842 ? var1.field25060 : var1.field25061, field13202, field13203) * field13204 * field13205
                  - field13206
            )
         );
         if ((
               ItemFeatureProperties.method05420(var0.field19838, ItemTagAliases.field23902)
                  || ItemFeatureProperties.method05404(var0.field19838, Items.ENDER_PEARL)
                  || ItemFeatureProperties.method05404(var0.field19838, Items.ENDER_EYE)
                  || ItemFeatureProperties.method05416(var0.field19838)
                  || ItemFeatureProperties.method05420(var0.field19838, ItemTagAliases.field23905)
                  || ItemFeatureProperties.method05420(var0.field19838, ItemTagAliases.field23906)
                  || var15
            )
            && !var4.equals(field13207)) {
            ItemAnimationMath.method00513(var3, field13208 * var70);
            ItemAnimationMath.method00527(var3, field13209 * var70);
            ItemAnimationMath.method00527(var3, ItemAnimationMath.method00520(field13210 * var1.field25042, 0.0, field13211));
            boolean var71 = var0.field19842 && var0.field19857 || var0.field19858;
            if (ItemFeatureProperties.method05420(var0.field19838, ItemTagAliases.field23906)) {
               if (var71) {
                  ItemAnimationSoundPlayer.method08452(field13212, field13213);
               }

               ItemAnimationMath.method00527(var3, field13214);
               ItemAnimationMath.method00511(
                  var3,
                  field13215
                     * AnimationCurveMath.method08367(
                        var0.field19842
                           ? ItemAnimationMath.method00520(var1.field25060 * field13216, 0.0, 1.0)
                           : ItemAnimationMath.method00520(var1.field25061 * field13217, 0.0, 1.0)
                     ),
                  0.0,
                  field13218,
                  0.0
               );
            } else if (ItemFeatureProperties.method05420(var0.field19838, ItemTagAliases.field23905)) {
               if (var71) {
                  ItemAnimationSoundPlayer.method08452(field13219, field13220);
               }

               ItemAnimationMath.method00509(
                  var3,
                  field13221
                     * AnimationCurveMath.method08367(
                        var0.field19842
                           ? ItemAnimationMath.method00520(var1.field25060 * field13222, 0.0, 1.0)
                           : ItemAnimationMath.method00520(var1.field25061 * field13223, 0.0, 1.0)
                     ),
                  field13224 * var5,
                  field13225,
                  0.0
               );
            } else {
               if (var71) {
                  ItemAnimationSoundPlayer.method08452(field13226, field13227);
               }

               double var54 = var0.field19842
                  ? ItemAnimationMath.method00520(var1.field25060 * field13228, 0.0, 1.0)
                  : ItemAnimationMath.method00520(var1.field25061 * field13229, 0.0, 1.0);
               ItemAnimationMath.method00524(
                  var3,
                  field13230
                     * var5
                     * ItemAnimationMath.method00526(ItemAnimationMath.method00520(var54, field13231, field13232) * field13233 * field13234 - field13235)
               );
            }
         }

         double var72 = AnimationCurveMath.method08367(var1.field25013);
         double var55 = AnimationCurveMath.method08367(var1.field25014);
         if (ItemFeatureProperties.method05404(var0.field19838, Items.FILLED_MAP)) {
            ItemAnimationMath.method00524(var3, field13236 * var5 * var72);
            ItemAnimationMath.method00512(var3, (field13237 - field13238 * var55) * var5 * var72);
            ItemAnimationMath.method00524(var3, field13239 * var5 * var72);
            ItemAnimationMath.method00513(var3, field13240 * var55 * var72);
         }

         if (ItemFeatureProperties.method05404(var0.field19838, Items.FILLED_MAP)) {
            double var57 = 1.0 - var72;
            ItemAnimationMath.method00517(var3, field13241 * var57);
            ItemAnimationMath.method00527(var3, field13242 * var57);
            ItemAnimationMath.method00513(var3, field13243 * var57);
            ItemAnimationMath.method00512(var3, field13244 * var5 * var57);
            ItemAnimationMath.method00524(var3, field13245 * var5 * var57);
         } else if (ItemFeatureProperties.method05414(var0.field19838)
            && !var9
            && !ItemFeatureProperties.method05404(var0.field19838, Items.BONE)
            && !var4.equals(field13246)
            && !var4.equals(field13247)) {
            ItemAnimationMath.method00529(var3, field13248 * var5);
            ItemAnimationMath.method00513(var3, field13249);
            ItemAnimationMath.method00512(var3, field13250 * var5);
            ItemAnimationMath.method00524(var3, field13251 * var5);
         }

         if (ItemFeatureProperties.method05415(var0.field19838)) {
            ItemAnimationMath.method00529(var3, field13252 * var5);
            ItemAnimationMath.method00513(var3, field13253);
            ItemAnimationMath.method00512(var3, field13254 * var5);
            ItemAnimationMath.method00524(var3, field13255 * var5);
         }

         if (ItemFeatureProperties.method05404(var0.field19838, Items.SHEARS)) {
            if (!var0.field19843) {
               ItemAnimationMath.method00517(var3, field13256);
               ItemAnimationMath.method00512(var3, field13257);
            }

            ItemAnimationMath.method00524(var3, field13258);
         }

         if (var15 && !ItemFeatureProperties.method05404(var0.field19838, Items.DRAGON_HEAD)) {
            ItemAnimationMath.method00529(var3, field13259 * var5);
            ItemAnimationMath.method00527(var3, field13260);
            ItemAnimationMath.method00524(var3, field13261 * var5);
            ItemAnimationMath.method00512(var3, field13262 * var5);
            ItemAnimationMath.method00513(var3, field13263);
         } else if (ItemFeatureProperties.method05404(var0.field19838, Items.DRAGON_HEAD)) {
            ItemAnimationMath.method00527(var3, field13264);
            ItemAnimationMath.method00524(var3, field13265 * var5);
            ItemAnimationMath.method00512(var3, field13266 * var5);
         }

         if (var0.field19842 && var0.field19857 || var0.field19858) {
            ItemAnimationSoundPlayer.method08452(field13267, field13268);
         }

         if (ItemFeatureProperties.method05404(var0.field19838, Items.BREWING_STAND)
            || ItemFeatureProperties.method05404(var0.field19838, Items.REDSTONE_TORCH)
            || ItemFeatureProperties.method05404(var0.field19838, Items.TORCH)
            || ItemFeatureProperties.method05404(var0.field19838, Items.LANTERN)
            || ItemFeatureProperties.method05404(var0.field19838, Items.SOUL_TORCH)
            || ItemFeatureProperties.method05404(var0.field19838, Items.SOUL_LANTERN)) {
            if (ItemFeatureProperties.method05404(var0.field19838, Items.BREWING_STAND) || ItemFeatureProperties.method05404(var0.field19838, Items.TORCH)) {
               method05961(
                  var0,
                  field13269 * var5,
                  field13270,
                  field13271,
                  field13272,
                  field12744,
                  field13273 + field13274 * ItemAnimationMath.method00526(PlayerAnimationUtils.method09040(var2) * field13275)
               );
            } else if (ItemFeatureProperties.method05404(var0.field19838, Items.LANTERN)) {
               method05961(
                  var0,
                  field13276 * var5,
                  field13277,
                  field13278,
                  field13279,
                  field12744,
                  field13280 + field13281 * ItemAnimationMath.method00526(PlayerAnimationUtils.method09040(var2) * field13282)
               );
            } else if (var10 && var8.contains(field13283)) {
               method05961(
                  var0,
                  field13284 * var5,
                  field13285,
                  field13286,
                  field13287,
                  field12744,
                  field13288 + field13289 * ItemAnimationMath.method00526(PlayerAnimationUtils.method09040(var2) * field13290)
               );
            } else if (ItemFeatureProperties.method05404(var0.field19838, Items.SOUL_TORCH)) {
               method05961(
                  var0,
                  field13291 * var5,
                  field13292,
                  field13293,
                  field13294,
                  field12745,
                  field13295 + field13296 * ItemAnimationMath.method00526(PlayerAnimationUtils.method09040(var2) * field13297)
               );
            } else if (ItemFeatureProperties.method05404(var0.field19838, Items.SOUL_LANTERN)) {
               method05961(
                  var0,
                  field13298 * var5,
                  field13299,
                  field13300,
                  field13301,
                  field12745,
                  field13302 + field13303 * ItemAnimationMath.method00526(PlayerAnimationUtils.method09040(var2) * field13304)
               );
            } else if (ItemFeatureProperties.method05404(var0.field19838, Items.REDSTONE_TORCH)) {
               method05961(
                  var0,
                  field13305 * var5,
                  field13306,
                  field13307,
                  field13308,
                  field12746,
                  field13309 + field13310 * ItemAnimationMath.method00526(PlayerAnimationUtils.method09040(var2) * field13311)
               );
            }
         }

         int var73 = var1.field24994 != 0 ? var1.field24994 : 67;
         if (ItemAnimationChecks.method10893(var73)) {
            var1.field25011 = var1.field25011 + field13312 * var0.field19847 * field13313;
         } else {
            var1.field25011 = 0.0;
         }

         var1.field25011 = ItemAnimationMath.method00520(var1.field25011, 0.0, 1.0);
         if ((var11 || var12 || var13 || var4.equals(field13314)) && var0.field19842) {
            ItemAnimationMath.method00529(var3, field13315 * var5 * var1.field25010);
            ItemAnimationMath.method00511(var3, field13316 * AnimationCurveMath.method08367(var1.field25011), 0.0, 0.0, field13317);
         }

         var1.field25075 = PlayerAnimationUtils.method09040(var2);
         if (var1.field25074 != PlayerAnimationUtils.method09041(var2) && var0.field19842 && ItemFeatureProperties.method05404(var0.field19838, Items.BELL)) {
            ItemAnimationSoundPlayer.method08452(field13318, field13319);
         }

         var1.field25074 = PlayerAnimationUtils.method09041(var2);
         if (ItemFeatureProperties.method05404(var0.field19838, Items.PINK_PETALS)
            || ItemFeatureProperties.method05404(var0.field19838, Items.WILDFLOWERS)
            || ItemFeatureProperties.method05404(var0.field19838, Items.LEAF_LITTER)) {
            Identifier var58;
            Identifier var59;
            Identifier var60;
            if (ItemFeatureProperties.method05404(var0.field19838, Items.PINK_PETALS)) {
               var58 = field12748;
               var59 = field12749;
               var60 = field12750;
            } else if (ItemFeatureProperties.method05404(var0.field19838, Items.WILDFLOWERS)) {
               var58 = field12751;
               var59 = field12752;
               var60 = field12753;
            } else {
               var58 = field12754;
               var59 = field12755;
               var60 = field12756;
            }

            if (var1.field25004 != var0.field19853 && var0.field19842) {
               ItemAnimationSoundPlayer.method08452(field13320, field13321);
               method05960(var0, var5, var58, var59, var60);
            } else if (var1.field25003 != var0.field19854 && !var0.field19842) {
               ItemAnimationSoundPlayer.method08452(field13322, field13323);
               method05960(var0, var5, var58, var59, var60);
            }
         }

         if (var0.field19842) {
            var1.field25004 = var0.field19853;
         } else {
            var1.field25003 = var0.field19854;
         }

         if (ItemFeatureProperties.method05420(var0.field19838, ItemTagAliases.field23904)) {
            var1.field25110.put(var8, false);
         }

         if (var14) {
            var1.field25114.put(var8, 14);
         }

         double var74 = AnimationCurveMath.method08374(var0.field19842 ? var1.field25053 : var1.field25055);
         if (ItemFeatureProperties.method05404(var0.field19838, Items.BUCKET)
            || ItemFeatureProperties.method05404(var0.field19838, Items.AXOLOTL_BUCKET)
            || ItemFeatureProperties.method05404(var0.field19838, Items.POWDER_SNOW_BUCKET)
            || ItemFeatureProperties.method05404(var0.field19838, Items.PUFFERFISH_BUCKET)
            || ItemFeatureProperties.method05404(var0.field19838, Items.TADPOLE_BUCKET)
            || ItemFeatureProperties.method05404(var0.field19838, Items.SALMON_BUCKET)
            || ItemFeatureProperties.method05404(var0.field19838, Items.COD_BUCKET)
            || ItemFeatureProperties.method05404(var0.field19838, Items.TROPICAL_FISH_BUCKET)
            || ItemFeatureProperties.method05404(var0.field19838, Items.WATER_BUCKET)
            || ItemFeatureProperties.method05404(var0.field19838, Items.LAVA_BUCKET)) {
            ItemAnimationMath.method00527(var3, field13324);
            ItemAnimationMath.method00529(var3, 0.0 * var5);
            ItemAnimationMath.method00517(var3, field13325);
            ItemAnimationMath.method00512(var3, field13326);
            ItemAnimationMath.method00513(var3, field13327);
            ItemAnimationMath.method00524(var3, field13328 * var5);
         }

         if (ItemFeatureProperties.method05404(var0.field19838, Items.MILK_BUCKET)) {
            ItemAnimationMath.method00527(var3, field13329);
            ItemAnimationMath.method00529(var3, 0.0 * var5);
            ItemAnimationMath.method00517(var3, field13330);
            ItemAnimationMath.method00512(var3, field13331);
            ItemAnimationMath.method00513(var3, field13332);
            ItemAnimationMath.method00524(var3, field13333 * var5);
            ItemAnimationMath.method00513(var3, 0.0 * var74);
            ItemAnimationMath.method00524(var3, field13334 * var5 * var74);
            ItemAnimationMath.method00512(var3, 0.0 * var5 * var74);
            ItemAnimationMath.method00529(var3, 0.0 * var5 * var74);
            ItemAnimationMath.method00527(var3, field13335 * var74);
            ItemAnimationMath.method00517(var3, field13336 * var74);
         }

         if (ItemFeatureProperties.method05404(var0.field19838, Items.LAVA_BUCKET)) {
            method05961(
               var0,
               field13337 * var5,
               0.0,
               0.0,
               field13338,
               field12744,
               field13339 + field13340 * ItemAnimationMath.method00526(PlayerAnimationUtils.method09040(var2) * field13341)
            );
         }

         if (var8.equals(field13342) || var8.equals(field13343) || var8.equals(field13344)) {
            ItemAnimationMath.method00527(var3, field13345);
            ItemAnimationMath.method00529(var3, 0.0 * var5);
            ItemAnimationMath.method00517(var3, field13346);
            ItemAnimationMath.method00512(var3, field13347);
            ItemAnimationMath.method00513(var3, field13348);
            ItemAnimationMath.method00524(var3, field13349 * var5);
         }

         if (var4.equals(field13350)) {
            double var75 = AnimationCurveMath.method08375(
               ItemAnimationMath.method00520(var0.field19842 ? var1.field25036 : var1.field25032 * field13351, 0.0, 1.0)
            );
            ItemAnimationMath.method00513(var3, field13352 * var75);
            ItemAnimationMath.method00524(var3, field13353 * var5 * var75);
            ItemAnimationMath.method00517(var3, field13354);
            ItemAnimationMath.method00512(var3, field13355 * var5);
         }

         if (var4.equals(field13356)) {
            ItemAnimationMath.method00517(var3, field13357);
            ItemAnimationMath.method00512(var3, field13358 * var5);
         }

         if (var4.equals(field13359)) {
            ItemAnimationMath.method00513(
               var3,
               field13360 * AnimationCurveMath.method08375(ItemAnimationMath.method00526(var0.field19842 ? var1.field25007 : var1.field25008 * field13361))
            );
            ItemAnimationMath.method00524(
               var3,
               field13362
                  * var5
                  * AnimationCurveMath.method08375(ItemAnimationMath.method00526(var0.field19842 ? var1.field25007 : var1.field25008 * field13363))
            );
         }

         if (var16
            || ItemFeatureProperties.method05420(var0.field19838, ItemTagAliases.field23900)
            || var15
            || ItemFeatureProperties.method05420(var0.field19838, ItemTagAliases.field23899)) {
            var1.field25112.put(var8, false);
         }

         if (var9
            && var1.field25112.getOrDefault(var8, true)
            && var1.field25110.getOrDefault(var8, true)
            && !ItemFeatureProperties.method05404(var0.field19838, Items.PINK_PETALS)
            && !ItemFeatureProperties.method05404(var0.field19838, Items.LEAF_LITTER)
            && !ItemFeatureProperties.method05404(var0.field19838, Items.WILDFLOWERS)
            && !ItemFeatureProperties.method05404(var0.field19838, Items.REDSTONE)
            && !ItemFeatureProperties.method05404(var0.field19838, Items.BELL)) {
            ItemAnimationMath.method00517(var3, field13364);
            if (!var10) {
               ItemAnimationMath.method00527(var3, field13365);
               ItemAnimationMath.method00524(var3, field13366 * var5);
               ItemAnimationMath.method00513(var3, field13367);
            }

            ItemAnimationMath.method00512(var3, field13368 * var5);
            ItemAnimationMath.method00516(var3, field13369, field13370, field13371);
         }

         double var76 = AnimationCurveMath.method08375(var1.field25031);
         double var62 = AnimationCurveMath.method08375(var1.field25029);
         double var64 = var0.field19842 ? var76 : var62;
         if (var64 < field13372) {
            var1.field25113.put(field13373, false);
         } else {
            var1.field25113.put(field13374, true);
         }

         var1.field25115.put(field13375, AnimationCurveMath.method08384(var64) * field13376);
      }
   }
}
