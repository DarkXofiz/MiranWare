// Original binary: sg/ec/yuVDN6CdBRlWUsHp
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

// $VF: Compiled from s
public final class WeaponItemTypes {
   private static final double field26519 = 0.1;
   private static final double field26520 = 0;
   private static final double field26521 = 0;
   private static final String field26522 = "spear";
   private static final double field26523 = -1.0;
   private static final double field26524 = 0.2;
   private static final double field26525 = 0.70016;
   private static final double field26526 = 0.308;
   private static final double field26527 = 5.1;
   private static final double field26528 = 0.70016;
   private static final double field26529 = 5.1;
   private static final double field26530 = 2.0;
   private static final double field26531 = 0.65245;
   private static final double field26532 = 0.16675;
   private static final double field26533 = 3.14;
   private static final double field26534 = 3.0;
   private static final double field26535 = 0.65245;
   private static final double field26536 = 4.4;
   private static final double field26537 = 1.2584;
   private static final double field26538 = 4.78;
   private static final double field26539 = 0.16561;
   private static final double field26540 = 0.49422;
   private static final double field26541 = 4.78;
   private static final double field26542 = 2.0;
   private static final double field26543 = 4.7;
   private static final double field26544 = 0.65594;
   private static final double field26545 = 0.16561;
   private static final double field26546 = 0.32991;
   private static final double field26547 = 4.78;
   private static final double field26548 = 2.0;
   private static final double field26549 = 4.7;
   private static final double field26550 = 0.65594;
   private static final double field26551 = 0.82025;
   private static final double field26552 = 4.78;
   private static final double field26553 = 2.0;
   private static final double field26554 = 4.7;
   private static final String field26555 = "bow";
   private static final double field26556 = 0.075;
   private static final double field26557 = 30.0;
   private static final double field26558 = 0.07;
   private static final double field26559 = 30.0;
   private static final String field26560 = "bow";
   private static final double field26561 = 0.025;
   private static final double field26562 = 30.0;
   private static final double field26563 = 0.07;
   private static final double field26564 = 30.0;
   private static final double field26565 = 0.11;
   private static final double field26566 = 30.0;
   private static final String field26567 = "bow";
   private static final double field26568 = 0.075;
   private static final double field26569 = 30.0;
   private static final double field26570 = 0.07;
   private static final double field26571 = 30.0;
   private static final String field26572 = "bow";
   private static final double field26573 = 0.025;
   private static final double field26574 = 30.0;
   private static final double field26575 = 0.07;
   private static final double field26576 = 30.0;
   private static final double field26577 = 0.05;
   private static final double field26578 = 2.0;
   private static final double field26579 = 30.0;
   private static final double field26580 = 0.07;
   private static final double field26581 = 30.0;
   private static final double field26582 = 0.07;
   private static final double field26583 = 30.0;
   private static final float field26584 = 3.0F;
   private static final double field26585 = -0.16;
   private static final double field26586 = -0.08;
   private static final double field26587 = 0.07;
   private static final double field26588 = 30.0;
   private static final double field26589 = 0.07;
   private static final double field26590 = 30.0;
   private static final double field26591 = 0.015;
   private static final double field26592 = 30.0;
   private static final double field26593 = 0.5;
   private static final double field26594 = 3.14;
   private static final double field26595 = 0.125;
   private static final double field26596 = 12.56;
   private static final String field26597 = "trident";
   private static final double field26598 = 0.9;
   private static final double field26599 = -0.15;
   private static final double field26600 = -0.3;
   private static final double field26601 = 75.0;
   private static final double field26602 = 0.3;
   private static final double field26603 = -0.4;
   private static final double field26604 = -75.0;
   private static final double field26605 = 0.3;
   private static final double field26606 = -0.4;
   private static final double field26607 = 0.15;
   private static final double field26608 = 0.3;
   private static final String field26609 = "crossbow";
   private static final double field26610 = -0.25;
   private static final double field26611 = -0.2;
   private static final double field26612 = 25.0;
   private static final double field26613 = 0.3;
   private static final double field26614 = -0.4;
   private static final double field26615 = -55.0;
   private static final double field26616 = 0.3;
   private static final double field26617 = -0.4;
   private static final double field26618 = 40.0;
   private static final double field26619 = 0.3;
   private static final double field26620 = -0.4;
   private static final double field26621 = -40.0;
   private static final double field26622 = 0.3;
   private static final double field26623 = -0.4;
   private static final double field26624 = 55.0;
   private static final double field26625 = 0.3;
   private static final double field26626 = -0.4;
   private static final double field26627 = -25.0;
   private static final double field26628 = 0.3;
   private static final double field26629 = -0.4;
   private static final String field26630 = "crossbow";
   private static final double field26631 = 0.25;
   private static final double field26632 = 0.2;
   private static final double field26633 = 0.015;
   private static final double field26634 = 30.0;
   private static final double field26635 = 0.5;
   private static final double field26636 = 3.14;
   private static final double field26637 = 0.125;
   private static final double field26638 = 12.56;
   private static final String field26639 = "crossbow";
   private static final double field26640 = -0.25;
   private static final double field26641 = -0.2;
   private static final double field26642 = 25.0;
   private static final double field26643 = 0.3;
   private static final double field26644 = -0.4;
   private static final double field26645 = -55.0;
   private static final double field26646 = 0.3;
   private static final double field26647 = -0.4;
   private static final double field26648 = 40.0;
   private static final double field26649 = 0.3;
   private static final double field26650 = -0.4;
   private static final double field26651 = -40.0;
   private static final double field26652 = 0.3;
   private static final double field26653 = -0.4;
   private static final double field26654 = 55.0;
   private static final double field26655 = 0.3;
   private static final double field26656 = -0.4;
   private static final double field26657 = -25.0;
   private static final double field26658 = 0.3;
   private static final double field26659 = -0.4;
   private static final String field26660 = "crossbow";
   private static final double field26661 = 0.25;
   private static final double field26662 = 0.2;
   private static final double field26663 = 0.08;
   private static final double field26664 = 30.0;
   private static final double field26665 = 40.0;
   private static final double field26666 = 0.05;
   private static final double field26667 = 30.0;
   private static final double field26668 = 0.095;
   private static final double field26669 = 30.0;
   private static final String field26670 = "spear";
   private static final double field26671 = 0.08;
   private static final double field26672 = 30.0;
   private static final double field26673 = 0.035;
   private static final double field26674 = 30.0;
   private static final double field26675 = 0.055;
   private static final double field26676 = 30.0;
   private static final double field26677 = 0.08;
   private static final double field26678 = 30.0;
   private static final double field26679 = 0.08;
   private static final double field26680 = 30.0;
   private static final double field26681 = 0.08;
   private static final double field26682 = 30.0;
   private static final double field26683 = 8.0;
   private static final String field26684 = "spear";
   private static final double field26685 = 0.08;
   private static final double field26686 = 30.0;
   private static final double field26687 = 0.035;
   private static final double field26688 = 30.0;
   private static final double field26689 = 0.055;
   private static final double field26690 = 30.0;
   private static final double field26691 = 0.08;
   private static final double field26692 = 30.0;
   private static final double field26693 = 8.0;
   private static final double field26694 = 0.5;
   private static final double field26695 = 30.0;
   private static final double field26696 = 0.5;
   private static final double field26697 = 30.0;
   private static final double field26698 = 0.5;
   private static final double field26699 = 30.0;
   private static final double field26700 = 0.5;
   private static final double field26701 = 30.0;
   private static final String field26702 = "eat";
   private static final String field26703 = "drink";
   private static final String field26704 = "toot_horn";
   private static final double field26705 = 0.1;
   private static final double field26706 = 30.0;
   private static final double field26707 = 0.1;
   private static final double field26708 = 30.0;
   private static final String field26709 = "eat";
   private static final String field26710 = "drink";
   private static final String field26711 = "toot_horn";
   private static final String field26712 = "brush";
   private static final double field26713 = 0.4;
   private static final double field26714 = 0.1;
   private static final double field26715 = 30.0;
   private static final String field26716 = "eat";
   private static final String field26717 = "drink";
   private static final String field26718 = "toot_horn";
   private static final double field26719 = 0.1;
   private static final double field26720 = 30.0;
   private static final double field26721 = 0.1;
   private static final double field26722 = 30.0;
   private static final String field26723 = "eat";
   private static final String field26724 = "drink";
   private static final String field26725 = "toot_horn";
   private static final String field26726 = "brush";
   private static final double field26727 = 0.4;
   private static final double field26728 = 0.1;
   private static final double field26729 = 30.0;
   private static final String field26730 = "drink";
   private static final double field26731 = 0.04;
   private static final double field26732 = 30.0;
   private static final double field26733 = 0.1;
   private static final double field26734 = 30.0;
   private static final String field26735 = "drink";
   private static final double field26736 = 0.04;
   private static final double field26737 = 30.0;
   private static final double field26738 = 0.1;
   private static final double field26739 = 30.0;
   private static final String field26740 = "crossbow";
   private static final double field26741 = 0.1;
   private static final double field26742 = 30.0;
   private static final double field26743 = 0.1;
   private static final double field26744 = 30.0;
   private static final String field26745 = "crossbow";
   private static final double field26746 = 0.02;
   private static final double field26747 = 30.0;
   private static final double field26748 = 0.1;
   private static final double field26749 = 30.0;
   private static final String field26750 = "crossbow";
   private static final double field26751 = 0.1;
   private static final double field26752 = 30.0;
   private static final double field26753 = 0.1;
   private static final double field26754 = 30.0;
   private static final String field26755 = "crossbow";
   private static final double field26756 = 0.02;
   private static final double field26757 = 30.0;
   private static final double field26758 = 0.1;
   private static final double field26759 = 30.0;
   private static final String field26760 = "block";
   private static final String field26761 = "eat";
   private static final String field26762 = "toot_horn";
   private static final String field26763 = "drink";
   private static final String field26764 = "brush";
   private static final String field26765 = "spear";
   private static final double field26766 = 0.08;
   private static final double field26767 = 30.0;
   private static final double field26768 = 0.08;
   private static final double field26769 = 30.0;
   private static final String field26770 = "brush";
   private static final double field26771 = 0.1;
   private static final double field26772 = 30.0;
   private static final double field26773 = 0.1;
   private static final double field26774 = 30.0;
   private static final String field26775 = "brush";
   private static final double field26776 = 0.1;
   private static final double field26777 = 30.0;
   private static final double field26778 = 0.1;
   private static final double field26779 = 30.0;
   private static final String field26780 = "trident";
   private static final double field26781 = 0.07;
   private static final double field26782 = 30.0;
   private static final double field26783 = 0.045;
   private static final double field26784 = 30.0;
   private static final double field26785 = 0.1;
   private static final double field26786 = 30.0;
   private static final double field26787 = 0.57;
   private static final double field26788 = 30.0;
   private static final double field26789 = 0.53;
   private static final double field26790 = 30.0;
   private static final double field26791 = 0.1;
   private static final double field26792 = 30.0;
   private static final double field26793 = 0.07;
   private static final double field26794 = 30.0;
   private static final double field26795 = 0.1;
   private static final double field26796 = 30.0;
   private static final String field26797 = "trident";
   private static final double field26798 = 0.07;
   private static final double field26799 = 30.0;
   private static final double field26800 = 0.05;
   private static final double field26801 = 30.0;
   private static final double field26802 = 0.1;
   private static final double field26803 = 30.0;
   private static final double field26804 = 0.57;
   private static final double field26805 = 30.0;
   private static final double field26806 = 0.53;
   private static final double field26807 = 30.0;
   private static final double field26808 = 0.1;
   private static final double field26809 = 30.0;
   private static final double field26810 = 0.07;
   private static final double field26811 = 30.0;
   private static final double field26812 = 0.1;
   private static final double field26813 = 30.0;
   private static final double field26814 = 0.95;
   private static final float field26815 = 30.0F;
   private static final String field26816 = "block";
   private static final double field26817 = 0.12;
   private static final double field26818 = 30.0;
   private static final double field26819 = 0.07;
   private static final double field26820 = 30.0;
   private static final double field26821 = 0.12;
   private static final double field26822 = 30.0;
   private static final double field26823 = 0.07;
   private static final double field26824 = 30.0;
   private static final double field26825 = 0.04;
   private static final double field26826 = 30.0;
   private static final String field26827 = "block";
   private static final double field26828 = 0.07;
   private static final double field26829 = 30.0;
   private static final double field26830 = 0.07;
   private static final double field26831 = 30.0;
   private static final double field26832 = 0.04;
   private static final double field26833 = 30.0;
   private static final double field26834 = 0.08;
   private static final double field26835 = 0.08;
   private static final double field26836 = 30.0;
   private static final double field26837 = 0.1;
   private static final double field26838 = 30.0;
   private static final double field26839 = 0.1;
   private static final double field26840 = 30.0;
   private static final double field26841 = -1.0;
   private static final double field26842 = 3.14;
   private static final double field26843 = 0.14;
   private static final double field26844 = 3.14;
   private static final double field26845 = 0.12;
   private static final double field26846 = 3.14;
   private static final double field26847 = 0.12;
   private static final double field26848 = 0.27;
   private static final double field26849 = 30.0;
   private static final double field26850 = 0.1;
   private static final double field26851 = 30.0;
   private static final double field26852 = 0.82;
   private static final float field26853 = 30.0F;
   private static final double field26854 = 30.0;
   private static final double field26855 = 0.1;
   private static final double field26856 = 30.0;
   private static final double field26857 = 0.1;
   private static final double field26858 = 30.0;
   private static final double field26859 = -0.08;
   private static final double field26860 = 4.0;
   private static final double field26861 = 3.14;
   private static final double field26862 = -0.4;
   private static final double field26863 = 0.04;
   private static final double field26864 = 30.0;
   private static final double field26865 = 0.1;
   private static final double field26866 = 30.0;
   private static final double field26867 = 0.1;
   private static final double field26868 = 30.0;
   private static final double field26869 = 0.1;
   private static final double field26870 = 30.0;
   private static final double field26871 = 0.1;
   private static final double field26872 = 30.0;
   private static final double field26873 = 0.08;
   private static final double field26874 = 0.1;
   private static final double field26875 = 30.0;
   private static final double field26876 = 0.06;
   private static final double field26877 = 30.0;
   private static final double field26878 = 0.08;
   private static final double field26879 = 30.0;
   private static final double field26880 = 2.0;
   private static final double field26881 = 30.0;
   private static final double field26882 = 30.0;
   private static final double field26883 = 0.1;
   private static final double field26884 = 30.0;
   private static final double field26885 = 0.1;
   private static final double field26886 = 30.0;
   private static final double field26887 = 0.3;
   private static final double field26888 = 0.55;
   private static final double field26889 = -0.03;
   private static final double field26890 = 0.1;
   private static final double field26891 = -0.4;
   private static final double field26892 = -0.03;
   private static final double field26893 = 0.1;
   private static final double field26894 = -0.4;
   private static final double field26895 = -0.15;
   private static final double field26896 = 0.55;
   private static final double field26897 = 0.25;
   private static final double field26898 = -15.0;
   private static final double field26899 = 0.55;
   private static final double field26900 = 0.3;
   private static final double field26901 = -0.4;
   private static final double field26902 = -10.0;
   private static final double field26903 = 0.55;
   private static final double field26904 = 0.3;
   private static final double field26905 = -0.4;
   private static final double field26906 = -30.0;
   private static final double field26907 = 0.3;
   private static final double field26908 = -0.4;
   private static final double field26909 = -20.0;
   private static final double field26910 = 0.55;
   private static final double field26911 = 0.3;
   private static final double field26912 = -0.4;
   private static final double field26913 = -15.0;
   private static final double field26914 = 0.55;
   private static final double field26915 = 0.3;
   private static final double field26916 = -0.4;
   private static final double field26917 = -10.0;
   private static final double field26918 = 0.55;
   private static final double field26919 = 0.3;
   private static final double field26920 = -0.4;
   private static final double field26921 = 0.25;
   private static final double field26922 = -0.05;
   private static final double field26923 = -0.12;
   private static final double field26924 = -10.0;
   private static final double field26925 = -0.1;
   private static final double field26926 = 0.05;
   private static final double field26927 = 25.0;
   private static final String field26928 = "crossbow";
   private static final double field26929 = -0.12;
   private static final double field26930 = -6.0;
   private static final double field26931 = 6.0;
   private static final double field26932 = 0.01;
   private static final double field26933 = 1.1;
   private static final double field26934 = 0.3;
   private static final double field26935 = -0.4;
   private static final double field26936 = 0.5;
   private static final double field26937 = 0.3;
   private static final double field26938 = -0.4;
   private static final double field26939 = 2.0;
   private static final double field26940 = 0.3;
   private static final double field26941 = 0.3;
   private static final double field26942 = -0.4;
   private static final double field26943 = -1.0;
   private static final double field26944 = 0.5;
   private static final double field26945 = 0.7;
   private static final double field26946 = 0.06;
   private static final double field26947 = 2.0;
   private static final double field26948 = -0.4;
   private static final double field26949 = 0.06;
   private static final double field26950 = 0.75;
   private static final double field26951 = 1.5;
   private static final double field26952 = -0.4;
   private static final double field26953 = -0.5;
   private static final double field26954 = 1.5;
   private static final double field26955 = -0.4;
   private static final double field26956 = 1.5;
   private static final double field26957 = -0.4;
   private static final String field26958 = "block";
   private static final double field26959 = 0.2;
   private static final double field26960 = 0.1;
   private static final double field26961 = 20.0;
   private static final double field26962 = 0.3;
   private static final double field26963 = -0.4;
   private static final String field26964 = "block";
   private static final double field26965 = 0.1;
   private static final double field26966 = 50.0;
   private static final double field26967 = 0.3;
   private static final double field26968 = -0.4;
   private static final double field26969 = 70.0;
   private static final double field26970 = 0.3;
   private static final double field26971 = -0.4;
   private static final double field26972 = 13.0;
   private static final double field26973 = 4.14;
   private static final double field26974 = 0.3;
   private static final double field26975 = -0.4;
   private static final double field26976 = -15.0;
   private static final double field26977 = 0.3;
   private static final double field26978 = -0.4;
   private static final String field26979 = "block";
   private static final double field26980 = 0.1;
   private static final double field26981 = 50.0;
   private static final double field26982 = 0.3;
   private static final double field26983 = -0.4;
   private static final double field26984 = 70.0;
   private static final double field26985 = 0.3;
   private static final double field26986 = -0.4;
   private static final double field26987 = 13.0;
   private static final double field26988 = 4.14;
   private static final double field26989 = 0.3;
   private static final double field26990 = -0.4;
   private static final double field26991 = -15.0;
   private static final double field26992 = 0.3;
   private static final double field26993 = -0.4;
   private static final String field26994 = "trident";
   private static final double field26995 = -0.15;
   private static final double field26996 = -0.3;
   private static final double field26997 = 65.0;
   private static final double field26998 = 0.3;
   private static final double field26999 = -0.4;
   private static final double field27000 = 55.0;
   private static final double field27001 = 0.3;
   private static final double field27002 = -0.4;
   private static final double field27003 = 10.0;
   private static final double field27004 = 0.3;
   private static final double field27005 = -0.4;
   private static final double field27006 = 0.3;
   private static final double field27007 = 9.14;
   private static final double field27008 = 0.3;
   private static final double field27009 = -0.4;
   private static final double field27010 = 0.6;
   private static final double field27011 = 0.2;
   private static final double field27012 = 0.25;
   private static final double field27013 = -0.15;
   private static final double field27014 = 25.0;
   private static final double field27015 = 0.3;
   private static final double field27016 = -0.4;
   private static final double field27017 = -30.0;
   private static final double field27018 = 0.3;
   private static final double field27019 = -0.4;
   private static final String field27020 = "trident";
   private static final double field27021 = -0.15;
   private static final double field27022 = -0.3;
   private static final double field27023 = 65.0;
   private static final double field27024 = 0.3;
   private static final double field27025 = -0.4;
   private static final double field27026 = 10.0;
   private static final double field27027 = 0.3;
   private static final double field27028 = -0.4;
   private static final double field27029 = 0.3;
   private static final double field27030 = 9.14;
   private static final double field27031 = 0.3;
   private static final double field27032 = -0.4;
   private static final double field27033 = 0.6;
   private static final double field27034 = 0.2;
   private static final double field27035 = 0.25;
   private static final double field27036 = -0.15;
   private static final double field27037 = 25.0;
   private static final double field27038 = 0.3;
   private static final double field27039 = -0.4;
   private static final double field27040 = -30.0;
   private static final double field27041 = 0.3;
   private static final double field27042 = -0.4;
   private static final double field27043 = 3.14;
   private static final double field27044 = 6.28;
   private static final double field27045 = 6.28;
   private static final double field27046 = -0.15;
   private static final double field27047 = 0.1;
   private static final double field27048 = 0.33;
   private static final double field27049 = 0.05;
   private static final double field27050 = 0.14;
   private static final double field27051 = -0.1;
   private static final double field27052 = 0.4;
   private static final double field27053 = 0.2;
   private static final double field27054 = -10.0;
   private static final double field27055 = 0.15;
   private static final double field27056 = -20.0;
   private static final double field27057 = 0.3;
   private static final double field27058 = -0.4;
   private static final double field27059 = -7.0;
   private static final double field27060 = 0.3;
   private static final double field27061 = -0.4;
   private static final double field27062 = 10.0;
   private static final double field27063 = 0.3;
   private static final double field27064 = -0.4;
   private static final double field27065 = 20.0;
   private static final double field27066 = 0.3;
   private static final double field27067 = -0.4;
   private static final double field27068 = 5.0;
   private static final double field27069 = 0.3;
   private static final double field27070 = -0.4;
   private static final double field27071 = -5.0;
   private static final double field27072 = 0.3;
   private static final double field27073 = -0.4;
   private static final double field27074 = 10.0;
   private static final double field27075 = 0.3;
   private static final double field27076 = -0.4;
   private static final double field27077 = 5.0;
   private static final double field27078 = 0.3;
   private static final double field27079 = -0.4;
   private static final double field27080 = 15.0;
   private static final double field27081 = 0.3;
   private static final double field27082 = -0.4;
   private static final double field27083 = -0.1;
   private static final double field27084 = -0.1;
   private static final double field27085 = -0.15;
   private static final double field27086 = 0.15;
   private static final double field27087 = -0.3;
   private static final double field27088 = 0.2;
   private static final double field27089 = -0.15;
   private static final double field27090 = 20.0;
   private static final double field27091 = 0.3;
   private static final double field27092 = -0.4;
   private static final double field27093 = 40.0;
   private static final double field27094 = 0.3;
   private static final double field27095 = -0.4;
   private static final double field27096 = 10.0;
   private static final double field27097 = 0.3;
   private static final double field27098 = -0.4;
   private static final double field27099 = 10.0;
   private static final double field27100 = 0.3;
   private static final double field27101 = -0.4;
   private static final double field27102 = -45.0;
   private static final double field27103 = 0.3;
   private static final double field27104 = -0.4;
   private static final double field27105 = -10.0;
   private static final double field27106 = 0.3;
   private static final double field27107 = -0.4;
   private static final double field27108 = -95.0;
   private static final double field27109 = 0.3;
   private static final double field27110 = -0.4;
   private static final double field27111 = 20.0;
   private static final double field27112 = 0.3;
   private static final double field27113 = -0.4;
   private static final double field27114 = 20.0;
   private static final double field27115 = -60.0;
   private static final double field27116 = 60.0;
   private static final double field27117 = 0.5;
   private static final double field27118 = -0.5;
   private static final String field27119 = "trident";
   private static final String field27120 = "spear";
   private static final double field27121 = 0.2;
   private static final double field27122 = -0.5;
   private static final double field27123 = -0.5;
   private static final double field27124 = -0.2;
   private static final double field27125 = -0.1;
   private static final double field27126 = -0.15;
   private static final double field27127 = 0.15;
   private static final double field27128 = -0.3;
   private static final double field27129 = 0.2;
   private static final double field27130 = 0.15;
   private static final double field27131 = 20.0;
   private static final double field27132 = 0.3;
   private static final double field27133 = -0.4;
   private static final double field27134 = 70.0;
   private static final double field27135 = 0.3;
   private static final double field27136 = -0.4;
   private static final double field27137 = 30.0;
   private static final double field27138 = 0.3;
   private static final double field27139 = -0.4;
   private static final double field27140 = 10.0;
   private static final double field27141 = 0.3;
   private static final double field27142 = -0.4;
   private static final double field27143 = 10.0;
   private static final double field27144 = 0.3;
   private static final double field27145 = -0.4;
   private static final double field27146 = -25.0;
   private static final double field27147 = 0.3;
   private static final double field27148 = -0.4;
   private static final double field27149 = -10.0;
   private static final double field27150 = 0.3;
   private static final double field27151 = -0.4;
   private static final double field27152 = -75.0;
   private static final double field27153 = 0.3;
   private static final double field27154 = -0.4;
   private static final String field27155 = "trident";
   private static final String field27156 = "spear";
   private static final double field27157 = -0.2;
   private static final double field27158 = -0.15;
   private static final double field27159 = -0.25;
   private static final double field27160 = 0.2;
   private static final double field27161 = -0.1;
   private static final double field27162 = -0.15;
   private static final double field27163 = 0.15;
   private static final double field27164 = -0.45;
   private static final double field27165 = 0.2;
   private static final double field27166 = -0.15;
   private static final double field27167 = 20.0;
   private static final double field27168 = 0.3;
   private static final double field27169 = -0.4;
   private static final double field27170 = -70.0;
   private static final double field27171 = 0.3;
   private static final double field27172 = -0.4;
   private static final double field27173 = 30.0;
   private static final double field27174 = 0.3;
   private static final double field27175 = -0.4;
   private static final double field27176 = 10.0;
   private static final double field27177 = 0.3;
   private static final double field27178 = -0.4;
   private static final double field27179 = 10.0;
   private static final double field27180 = 0.3;
   private static final double field27181 = -0.4;
   private static final double field27182 = -55.0;
   private static final double field27183 = 0.3;
   private static final double field27184 = -0.4;
   private static final double field27185 = -15.0;
   private static final double field27186 = 0.3;
   private static final double field27187 = -0.4;
   private static final double field27188 = -95.0;
   private static final double field27189 = 0.3;
   private static final double field27190 = -0.4;
   private static final String field27191 = "trident";
   private static final double field27192 = -0.5;
   private static final double field27193 = 0.1;
   private static final double field27194 = 0.37;
   private static final double field27195 = -0.15;
   private static final String field27196 = "trident";
   private static final double field27197 = -0.25;
   private static final double field27198 = -0.35;
   private static final double field27199 = -0.25;
   private static final double field27200 = 0.14;
   private static final double field27201 = -0.2;
   private static final double field27202 = -0.1;
   private static final double field27203 = -0.1;
   private static final double field27204 = -0.1;
   private static final String field27205 = "trident";
   private static final double field27206 = 80.0;
   private static final double field27207 = 20.0;
   private static final double field27208 = 6.0;
   private static final double field27209 = 5.0;
   private static final double field27210 = -40.0;
   private static final double field27211 = 15.0;
   private static final double field27212 = 15.0;
   private static final double field27213 = 20.0;
   private static final double field27214 = 10.0;
   private static final double field27215 = -10.0;
   private static final double field27216 = 10.0;
   private static final double field27217 = 2.0;
   private static final double field27218 = 30.0;
   private static final double field27219 = -0.1;
   private static final double field27220 = 2.0;
   private static final String field27221 = "trident";
   private static final double field27222 = -0.2;
   private static final double field27223 = -0.1;
   private static final double field27224 = -0.15;
   private static final double field27225 = 0.15;
   private static final double field27226 = -0.3;
   private static final double field27227 = 0.2;
   private static final double field27228 = -0.15;
   private static final double field27229 = 20.0;
   private static final double field27230 = 0.3;
   private static final double field27231 = -0.4;
   private static final double field27232 = -60.0;
   private static final double field27233 = 0.3;
   private static final double field27234 = -0.4;
   private static final double field27235 = -40.0;
   private static final double field27236 = 0.3;
   private static final double field27237 = -0.4;
   private static final double field27238 = 30.0;
   private static final double field27239 = 0.3;
   private static final double field27240 = -0.4;
   private static final double field27241 = 10.0;
   private static final double field27242 = 0.3;
   private static final double field27243 = -0.4;
   private static final double field27244 = 10.0;
   private static final double field27245 = 0.3;
   private static final double field27246 = -0.4;
   private static final double field27247 = -45.0;
   private static final double field27248 = 0.3;
   private static final double field27249 = -0.4;
   private static final double field27250 = -10.0;
   private static final double field27251 = 0.3;
   private static final double field27252 = -0.4;
   private static final double field27253 = -95.0;
   private static final double field27254 = 0.3;
   private static final double field27255 = -0.4;
   private static final double field27256 = 30.0;
   private static final double field27257 = 2.0;
   private static final double field27258 = 30.0;
   private static final double field27259 = -0.2;
   private static final double field27260 = 2.0;
   private static final double field27261 = -0.2;
   private static final double field27262 = -0.15;
   private static final double field27263 = -0.1;
   private static final double field27264 = -0.15;
   private static final double field27265 = 0.1;
   private static final double field27266 = -0.3;
   private static final double field27267 = 20.0;
   private static final double field27268 = 0.3;
   private static final double field27269 = -0.4;
   private static final double field27270 = -40.0;
   private static final double field27271 = 0.3;
   private static final double field27272 = -0.4;
   private static final double field27273 = -20.0;
   private static final double field27274 = 0.3;
   private static final double field27275 = -0.4;
   private static final double field27276 = 5.0;
   private static final double field27277 = 0.3;
   private static final double field27278 = -0.4;
   private static final double field27279 = -5.0;
   private static final double field27280 = 15.0;
   private static final double field27281 = -0.15;
   private static final double field27282 = -0.15;
   private static final double field27283 = -10.0;
   private static final double field27284 = -25.0;
   private static final double field27285 = -20.0;
   private static final double field27286 = 20.0;
   private static final double field27287 = -5.0;
   private static final double field27288 = 0.3;
   private static final double field27289 = -0.4;
   private static final double field27290 = 10.0;
   private static final double field27291 = 0.3;
   private static final double field27292 = -0.4;
   private static final double field27293 = 5.0;
   private static final double field27294 = 0.3;
   private static final double field27295 = -0.4;
   private static final double field27296 = 30.0;
   private static final double field27297 = 2.0;
   private static final double field27298 = 30.0;
   private static final double field27299 = -0.2;
   private static final double field27300 = 2.0;
   private static final double field27301 = 0.6;
   private static final double field27302 = -0.5;
   private static final double field27303 = -0.3;
   private static final double field27304 = -0.3;
   private static final double field27305 = -0.4;
   private static final double field27306 = 0.1;
   private static final double field27307 = -0.1;
   private static final double field27308 = -130.0;
   private static final double field27309 = 70.0;
   private static final double field27310 = 40.0;
   private static final double field27311 = 20.0;
   private static final double field27312 = 20.0;
   private static final double field27313 = -10.0;
   private static final double field27314 = -0.1;
   private static final double field27315 = -0.1;
   private static final double field27316 = -0.1;
   private static final double field27317 = -0.05;
   private static final double field27318 = 0.25;
   private static final double field27319 = 5.0;
   private static final double field27320 = 0.3;
   private static final double field27321 = -0.4;
   private static final double field27322 = -25.0;
   private static final double field27323 = 0.3;
   private static final double field27324 = -0.4;
   private static final double field27325 = 5.0;
   private static final double field27326 = 0.3;
   private static final double field27327 = -0.4;
   private static final double field27328 = -5.0;
   private static final double field27329 = 15.0;
   private static final double field27330 = -2.0;
   private static final double field27331 = 0.3;
   private static final double field27332 = -0.4;
   private static final double field27333 = 5.0;
   private static final double field27334 = 0.3;
   private static final double field27335 = -0.4;
   private static final double field27336 = 5.0;
   private static final double field27337 = 0.3;
   private static final double field27338 = -0.4;
   private static final String field27339 = "block";
   private static final double field27340 = 0.25;
   private static final double field27341 = 4.0;
   private static final double field27342 = 3.14;
   private static final double field27343 = 10.0;
   private static final double field27344 = 4.0;
   private static final double field27345 = 3.14;
   private static final double field27346 = 0.3;
   private static final double field27347 = -0.4;
   private static final double field27348 = 0.25;
   private static final double field27349 = 4.0;
   private static final double field27350 = 3.14;
   private static final double field27351 = 10.0;
   private static final double field27352 = 4.0;
   private static final double field27353 = 3.14;
   private static final double field27354 = 0.3;
   private static final double field27355 = -0.4;
   private static final String field27356 = "crossbow";
   private static final double field27357 = 0.25;
   private static final double field27358 = 20.0;
   private static final double field27359 = 0.3;
   private static final double field27360 = -0.4;
   private static final String field27361 = "bow";
   private static final String field27362 = "block";
   private static final double field27363 = 0.25;
   private static final double field27364 = -20.0;
   private static final double field27365 = 0.3;
   private static final double field27366 = -0.4;
   private static final double field27367 = 0.25;
   private static final double field27368 = 6.0;
   private static final double field27369 = -10.0;
   private static final double field27370 = 0.3;
   private static final double field27371 = -0.4;
   private static final double field27372 = 0.35;
   private static final double field27373 = 90.0;
   private static final double field27374 = 2.5;
   private static final double field27375 = 0.2;
   private static final double field27376 = 0.2;
   private static final double field27377 = -0.2;
   private static final double field27378 = -30.0;
   private static final double field27379 = 0.01;
   private static final double field27380 = 0.003;
   private static final double field27381 = -0.0025;
   private static final double field27382 = -0.05;
   private static final double field27383 = -0.2;
   private static final double field27384 = -0.1;
   private static final double field27385 = 0.2;
   private static final double field27386 = -0.2;
   private static final double field27387 = 10.0;
   private static final double field27388 = 20.0;
   private static final double field27389 = 20.0;
   private static final double field27390 = 0.3;
   private static final double field27391 = -0.55;
   private static final double field27392 = -45.0;
   private static final double field27393 = 16.0;
   private static final double field27394 = 20.0;
   private static final double field27395 = 0.3;
   private static final double field27396 = -0.4;
   private static final double field27397 = -7.0;
   private static final double field27398 = 0.01;
   private static final double field27399 = 0.005;
   private static final double field27400 = 0.003;
   private static final double field27401 = -0.0025;
   private static final double field27402 = -0.1;
   private static final double field27403 = -0.2;
   private static final double field27404 = -0.1;
   private static final double field27405 = -0.1;
   private static final String field27406 = "bow";
   private static final double field27407 = 0.15;
   private static final double field27408 = -0.085;
   private static final double field27409 = 0.1;
   private static final double field27410 = 0.085;
   private static final double field27411 = -0.1;
   private static final double field27412 = -0.2;
   private static final double field27413 = 0.15;
   private static final double field27414 = 5.0;
   private static final double field27415 = 3.14;
   private static final double field27416 = 0.3;
   private static final double field27417 = -0.4;
   private static final double field27418 = 15.0;
   private static final double field27419 = 0.3;
   private static final double field27420 = -0.4;
   private static final double field27421 = 0.3;
   private static final double field27422 = -0.4;
   private static final double field27423 = 0.0015;
   private static final double field27424 = 15.14;
   private static final String field27425 = "bow";
   private static final double field27426 = 0.15;
   private static final double field27427 = -0.085;
   private static final double field27428 = 0.1;
   private static final double field27429 = 0.085;
   private static final double field27430 = -0.1;
   private static final double field27431 = -0.2;
   private static final double field27432 = 0.15;
   private static final double field27433 = 5.0;
   private static final double field27434 = 3.14;
   private static final double field27435 = 0.3;
   private static final double field27436 = -0.4;
   private static final double field27437 = 15.0;
   private static final double field27438 = 0.3;
   private static final double field27439 = -0.4;
   private static final double field27440 = 0.3;
   private static final double field27441 = -0.4;
   private static final double field27442 = 0.0015;
   private static final double field27443 = 15.14;
   private static final double field27444 = 1.5;
   private static final double field27445 = 0.27;
   private static final double field27446 = 1.56;
   private static final double field27447 = 3.14;
   private static final double field27448 = -0.65;
   private static final double field27449 = 10.0;
   private static final double field27450 = 3.14;
   private static final double field27451 = 0.3;
   private static final double field27452 = -0.4;
   private static final double field27453 = 70.0;
   private static final double field27454 = 0.3;
   private static final double field27455 = -0.4;
   private static final double field27456 = 25.0;
   private static final double field27457 = 0.3;
   private static final double field27458 = -0.4;
   private static final double field27459 = 0.25;
   private static final double field27460 = 15.14;
   private static final double field27461 = 25.0;
   private static final double field27462 = 0.3;
   private static final double field27463 = -0.4;
   private static final double field27464 = -0.5;
   private static final double field27465 = 3.14;
   private static final double field27466 = 1.5;
   private static final double field27467 = 0.27;
   private static final double field27468 = 1.56;
   private static final double field27469 = 3.14;
   private static final double field27470 = -0.65;
   private static final double field27471 = 10.0;
   private static final double field27472 = 3.14;
   private static final double field27473 = 0.3;
   private static final double field27474 = -0.4;
   private static final double field27475 = 70.0;
   private static final double field27476 = 0.3;
   private static final double field27477 = -0.4;
   private static final double field27478 = 25.0;
   private static final double field27479 = 0.3;
   private static final double field27480 = -0.4;
   private static final double field27481 = 0.25;
   private static final double field27482 = 15.14;
   private static final double field27483 = 25.0;
   private static final double field27484 = 0.3;
   private static final double field27485 = -0.4;
   private static final double field27486 = -0.5;
   private static final double field27487 = 3.14;
   private static final String field27488 = "crossbow";
   private static final double field27489 = -0.15;
   private static final double field27490 = 0.3;
   private static final double field27491 = 20.0;
   private static final double field27492 = -0.3;
   private static final double field27493 = -0.4;
   private static final double field27494 = 15.0;
   private static final double field27495 = -0.3;
   private static final double field27496 = -0.4;
   private static final double field27497 = 1.5;
   private static final double field27498 = 0.25;
   private static final double field27499 = -0.1;
   private static final double field27500 = 0.55;
   private static final double field27501 = 1.56;
   private static final double field27502 = 3.14;
   private static final double field27503 = 15.0;
   private static final double field27504 = 0.3;
   private static final double field27505 = -0.4;
   private static final double field27506 = 80.0;
   private static final double field27507 = 0.3;
   private static final double field27508 = -0.4;
   private static final double field27509 = 15.0;
   private static final double field27510 = 0.3;
   private static final double field27511 = -0.4;
   private static final double field27512 = -7.0;
   private static final double field27513 = 0.3;
   private static final double field27514 = -0.4;
   private static final String field27515 = "crossbow";
   private static final double field27516 = -0.15;
   private static final double field27517 = 0.3;
   private static final double field27518 = 20.0;
   private static final double field27519 = -0.3;
   private static final double field27520 = -0.4;
   private static final double field27521 = 15.0;
   private static final double field27522 = -0.3;
   private static final double field27523 = -0.4;
   private static final double field27524 = 1.5;
   private static final double field27525 = 0.25;
   private static final double field27526 = -0.1;
   private static final double field27527 = 0.55;
   private static final double field27528 = 1.56;
   private static final double field27529 = 3.14;
   private static final double field27530 = 15.0;
   private static final double field27531 = 0.3;
   private static final double field27532 = -0.4;
   private static final double field27533 = 80.0;
   private static final double field27534 = 0.3;
   private static final double field27535 = -0.4;
   private static final double field27536 = 15.0;
   private static final double field27537 = 0.3;
   private static final double field27538 = -0.4;
   private static final double field27539 = -7.0;
   private static final double field27540 = 0.3;
   private static final double field27541 = -0.4;
   private static final String field27542 = "eat";
   private static final String field27543 = "toot_horn";
   private static final double field27544 = 0.155;
   private static final double field27545 = 0.135;
   private static final double field27546 = -0.27;
   private static final double field27547 = 30.0;
   private static final double field27548 = 20.0;
   private static final String field27549 = "eat";
   private static final double field27550 = 3.0;
   private static final double field27551 = 3.0;
   private static final double field27552 = 4.0;
   private static final double field27553 = 2.0;
   private static final double field27554 = 6.0;
   private static final double field27555 = 2.0;
   private static final double field27556 = 2.0;
   private static final double field27557 = 2.0;
   private static final double field27558 = 3.0;
   private static final double field27559 = 5.0;
   private static final double field27560 = 60.0;
   private static final double field27561 = 0.3;
   private static final double field27562 = -0.4;
   private static final double field27563 = 25.0;
   private static final double field27564 = 3.14;
   private static final double field27565 = 0.3;
   private static final double field27566 = -0.4;
   private static final String field27567 = "drink";
   private static final double field27568 = 0.1;
   private static final double field27569 = 0.11;
   private static final double field27570 = -0.5;
   private static final double field27571 = 50.0;
   private static final double field27572 = 20.0;
   private static final double field27573 = 2.0;
   private static final double field27574 = 6.0;
   private static final double field27575 = 60.0;
   private static final double field27576 = 0.3;
   private static final double field27577 = -0.4;
   private static final double field27578 = 25.0;
   private static final double field27579 = 3.14;
   private static final double field27580 = 0.3;
   private static final double field27581 = -0.4;
   private static final String field27582 = "eat";
   private static final String field27583 = "toot_horn";
   private static final double field27584 = 0.155;
   private static final double field27585 = 0.135;
   private static final double field27586 = -0.27;
   private static final double field27587 = 30.0;
   private static final double field27588 = 20.0;
   private static final String field27589 = "eat";
   private static final double field27590 = 3.0;
   private static final double field27591 = 3.0;
   private static final double field27592 = 4.0;
   private static final double field27593 = 2.0;
   private static final double field27594 = 6.0;
   private static final double field27595 = 2.0;
   private static final double field27596 = 2.0;
   private static final double field27597 = 2.0;
   private static final double field27598 = 3.0;
   private static final double field27599 = 5.0;
   private static final double field27600 = 60.0;
   private static final double field27601 = 0.3;
   private static final double field27602 = -0.4;
   private static final double field27603 = 25.0;
   private static final double field27604 = 3.14;
   private static final double field27605 = 0.3;
   private static final double field27606 = -0.4;
   private static final String field27607 = "drink";
   private static final double field27608 = 0.1;
   private static final double field27609 = 0.11;
   private static final double field27610 = -0.5;
   private static final double field27611 = 50.0;
   private static final double field27612 = 20.0;
   private static final double field27613 = 2.0;
   private static final double field27614 = 6.0;
   private static final double field27615 = 60.0;
   private static final double field27616 = 0.3;
   private static final double field27617 = -0.4;
   private static final double field27618 = 25.0;
   private static final double field27619 = 3.14;
   private static final double field27620 = 0.3;
   private static final double field27621 = -0.4;
   private static final String field27622 = "brush";
   private static final double field27623 = -0.2;
   private static final double field27624 = -0.2;
   private static final double field27625 = -0.3;
   private static final double field27626 = -0.2;
   private static final double field27627 = 4.14;
   private static final double field27628 = -0.3;
   private static final double field27629 = 4.14;
   private static final double field27630 = 10.0;
   private static final double field27631 = 3.14;
   private static final double field27632 = 20.0;
   private static final double field27633 = 10.0;
   private static final double field27634 = 4.14;
   private static final double field27635 = 30.0;
   private static final double field27636 = 30.0;
   private static final double field27637 = 4.14;
   private static final String field27638 = "brush";
   private static final double field27639 = -0.2;
   private static final double field27640 = -0.2;
   private static final double field27641 = -0.3;
   private static final double field27642 = -0.2;
   private static final double field27643 = 4.14;
   private static final double field27644 = -0.3;
   private static final double field27645 = 4.14;
   private static final double field27646 = 10.0;
   private static final double field27647 = 3.14;
   private static final double field27648 = 20.0;
   private static final double field27649 = 10.0;
   private static final double field27650 = 4.14;
   private static final double field27651 = 30.0;
   private static final double field27652 = 30.0;
   private static final double field27653 = 4.14;
   private static final double field27654 = 0.2;
   private static final double field27655 = 6.0;
   private static final double field27656 = 0.3;
   private static final double field27657 = -0.4;
   private static final double field27658 = 20.0;
   private static final double field27659 = 0.3;
   private static final double field27660 = -0.4;
   private static final String field27661 = "block";
   private static final double field27662 = 0.04;
   private static final double field27663 = 30.0;
   private static final String field27664 = "block";
   private static final double field27665 = 0.06;
   private static final double field27666 = 30.0;
   private static final String field27667 = "block";
   private static final double field27668 = -0.4;
   private static final double field27669 = 0.15;
   private static final double field27670 = -0.1;
   private static final double field27671 = -30.0;
   private static final double field27672 = -10.0;
   private static final double field27673 = 3.14;
   private static final double field27674 = -20.0;
   private static final double field27675 = -6.0;
   private static final double field27676 = 0.80041;
   private static final double field27677 = 3.14;
   private static final double field27678 = 5.0;
   private static final double field27679 = 0.45;
   private static final double field27680 = 30.0;
   private static final double field27681 = 0.8;
   private static final float field27682 = 30.0F;
   private static final double field27683 = -6.0;
   private static final double field27684 = -0.35;
   private static final double field27685 = 0.3;
   private static final double field27686 = 0.1;
   private static final double field27687 = 0.18;
   private static final double field27688 = 0.12;
   private static final double field27689 = 50.0;
   private static final double field27690 = -40.0;
   private static final double field27691 = 40.0;
   private static final double field27692 = 30.0;
   private static final double field27693 = 0.3;
   private static final double field27694 = -0.4;
   private static final double field27695 = 0.1;
   private static final double field27696 = -0.35;
   private static final double field27697 = 0.22;
   private static final double field27698 = 24.0;
   private static final double field27699 = 10.0;
   private static final String field27700 = "crossbow";
   private static final double field27701 = 0.1;
   private static final double field27702 = 0.2;
   private static final double field27703 = -5.0;
   private static final double field27704 = 0.3;
   private static final double field27705 = -0.4;
   private static final double field27706 = 20.0;
   private static final double field27707 = 0.3;
   private static final double field27708 = -0.4;
   private static final double field27709 = 0.04;
   private static final double field27710 = 30.0;
   private static final double field27711 = 0.04;
   private static final double field27712 = 30.0;
   private static final String field27713 = "trident";
   private static final double field27714 = 0.35;
   private static final double field27715 = -0.15;
   private static final double field27716 = 40.0;
   private static final double field27717 = 0.3;
   private static final double field27718 = -0.4;
   private static final double field27719 = 13.0;
   private static final double field27720 = 4.14;
   private static final double field27721 = 0.3;
   private static final double field27722 = -0.4;
   private static final double field27723 = 10.0;
   private static final double field27724 = 6.28;
   private static final double field27725 = 0.35;
   private static final double field27726 = -0.15;
   private static final double field27727 = 40.0;
   private static final double field27728 = 0.3;
   private static final double field27729 = -0.4;
   private static final double field27730 = 17.0;
   private static final double field27731 = 3.14;
   private static final double field27732 = 0.3;
   private static final double field27733 = -0.4;
   private static final String field27734 = "trident";
   private static final double field27735 = 0.08;
   private static final double field27736 = 30.0;
   private static final double field27737 = 0.08;
   private static final double field27738 = 30.0;
   private static final double field27739 = 0.025;
   private static final double field27740 = 30.0;
   private static final double field27741 = 0.025;
   private static final double field27742 = 30.0;
   private static final double field27743 = 0.95;
   private static final float field27744 = 30.0F;
   private static final float field27745 = 4.0F;
   private static final double field27746 = 6.0;
   private static final double field27747 = 0.95;
   private static final float field27748 = 30.0F;
   private static final float field27749 = 4.0F;
   private static final double field27750 = 6.0;
   private static final String field27751 = "trident";
   private static final double field27752 = 3.0;
   private static final double field27753 = 3.0;
   private static final double field27754 = 0.2;
   private static final double field27755 = -1.25;
   private static final double field27756 = 5.0;
   private static final double field27757 = -30.0;
   private static final double field27758 = 3.14;
   private static final double field27759 = 70.0;
   private static final double field27760 = 3.14;
   private static final double field27761 = 0.7;
   private static final double field27762 = 0.7;
   private static final String field27763 = "spear";
   private static final double field27764 = -0.25;
   private static final double field27765 = 0.1;
   private static final double field27766 = -20.0;
   private static final double field27767 = 0.75;
   private static final double field27768 = 3.14;
   private static final double field27769 = -0.25;
   private static final double field27770 = 0.25;
   private static final double field27771 = 8.0;
   private static final double field27772 = 40.0;
   private static final double field27773 = 3.14;
   private static final double field27774 = -0.2;
   private static final double field27775 = -0.35;
   private static final double field27776 = -8.0;
   private static final double field27777 = 0.5;
   private static final double field27778 = -0.5;
   private static final double field27779 = -0.35;
   private static final double field27780 = -1.5;
   private static final double field27781 = 1.5;
   private static final double field27782 = 0.5;
   private static final double field27783 = -0.5;
   private static final double field27784 = -1.5;
   private static final double field27785 = 3.0;
   private static final double field27786 = 0.5;
   private static final double field27787 = -0.5;
   private static final double field27788 = 5.0;
   private static final double field27789 = 3.14;
   private static final double field27790 = -30.0;
   private static final double field27791 = 0.5;
   private static final double field27792 = -0.5;
   private static final double field27793 = -0.35;
   private static final double field27794 = -8.0;
   private static final double field27795 = 2.0;
   private static final double field27796 = 6.28;
   private static final double field27797 = 2.0;
   private static final double field27798 = 6.28;
   private static final double field27799 = 0.5;
   private static final double field27800 = -0.5;
   private static final double field27801 = 20.0;
   private static final double field27802 = 2.0;
   private static final double field27803 = 3.14;
   private static final double field27804 = 2.0;
   private static final double field27805 = 3.14;
   private static final double field27806 = 0.5;
   private static final double field27807 = -0.5;

   private WeaponItemTypes() {
   }

   public static void method11659(ItemAnimationContext var0) {
      ItemFeatureVariables var1 = ItemFeatureVariables.field24990;
      AbstractClientPlayer var2 = var0.field19837;
      if (var2 != null) {
         String var3 = ItemFeatureProperties.method05406(var0.field19838);
         boolean var4 = PlayerAnimationUtils.method09046(var2);
         InteractionHand var5 = PlayerAnimationUtils.method09047(var2);
         PoseStack var6 = var0.field19839;
         double var7 = PlayerAnimationUtils.method09042(var2);
         ItemStack var9 = var0.field19838;
         boolean var10 = ItemFeatureProperties.method05419(var9);
         boolean var11 = ItemFeatureProperties.method05409(var9);
         boolean var12 = ItemFeatureProperties.method05420(var9, ItemTagAliases.field23895);
         boolean var13 = ItemFeatureProperties.method05420(var9, ItemTagAliases.field23894);
         boolean var14 = ItemFeatureProperties.method05420(var9, ItemTagAliases.field23896);
         boolean var15 = ItemFeatureProperties.method05404(var9, Items.MACE);
         boolean var16 = ItemFeatureProperties.method05404(var9, Items.FILLED_MAP);
         boolean var17 = ItemFeatureProperties.method05417(var9);
         if (var3.equals(field26522)) {
            var0.field19846 = 0.0F;
         }

         double var18 = var0.field19843 ? 1.0 : field26523;
         if (var13) {
            var0.field19845 = (float)ItemAnimationCurves.method02441(var0.field19845);
         } else {
            var0.field19845 = (float)ItemAnimationCurves.method02442(var0.field19845);
         }

         ItemAnimationMath.method00529(var6, field26524 * var18);
         double var20;
         if (var0.field19845 < field26525) {
            var20 = ItemAnimationMath.method00526(ItemAnimationMath.method00520(var0.field19845, 0.0, field26526) * field26527);
         } else {
            var20 = ItemAnimationMath.method00526(ItemAnimationMath.method00520(var0.field19845, field26528, 1.0) * field26529 - field26530);
         }

         double var22;
         if (var0.field19845 < field26531) {
            var22 = ItemAnimationMath.method00526(ItemAnimationMath.method00520(var0.field19845, 0.0, field26532) * field26533 * field26534);
         } else {
            var22 = ItemAnimationMath.method00526(ItemAnimationMath.method00520(var0.field19845, field26535, 1.0) * field26536 - field26537);
         }

         var20 = var20 * var20 * var20;
         double var24 = ItemAnimationMath.method00520(ItemAnimationMath.method00526(var0.field19845 * field26538), 0.0, 1.0);
         double var26 = ItemAnimationMath.method00526(
            ItemAnimationMath.method00520(var0.field19845, field26539, field26540) * field26541 * field26542 + field26543
         );
         double var28;
         if (var0.field19845 < field26544) {
            var28 = ItemAnimationMath.method00526(
               ItemAnimationMath.method00520(var0.field19845, field26545, field26546) * field26547 * field26548 + field26549
            );
         } else {
            var28 = ItemAnimationMath.method00526(
               ItemAnimationMath.method00520(var0.field19845, field26550, field26551) * field26552 * field26553 - field26554
            );
         }

         if (var4 && var3.equals(field26555) && !var0.field19842 && var5 == var0.field19841) {
            var1.field25028 = var1.field25028 + field26556 * var0.field19847 * field26557;
         } else if (!var0.field19842) {
            var1.field25028 = var1.field25028 - field26558 * var0.field19847 * field26559;
         }

         var1.field25028 = ItemAnimationMath.method00520(var1.field25028, 0.0, 1.0);
         if (var4 && var3.equals(field26560) && !var0.field19842 && var5 == var0.field19841 && var1.field25028 == 1.0) {
            var1.field25029 = var1.field25029 + field26561 * var0.field19847 * field26562;
            var1.field25027 = var1.field25027 + field26563 * var0.field19847 * field26564;
         } else if (!var0.field19842) {
            var1.field25029 = var1.field25029 - field26565 * var0.field19847 * field26566;
         }

         var1.field25029 = ItemAnimationMath.method00520(var1.field25029, 0.0, 1.0);
         if (var4 && var3.equals(field26567) && var0.field19842 && var5 == var0.field19841) {
            var1.field25030 = var1.field25030 + field26568 * var0.field19847 * field26569;
         } else if (var0.field19842) {
            var1.field25030 = var1.field25030 - field26570 * var0.field19847 * field26571;
         }

         var1.field25030 = ItemAnimationMath.method00520(var1.field25030, 0.0, 1.0);
         if (var4 && var3.equals(field26572) && var0.field19842 && var5 == var0.field19841 && var1.field25030 == 1.0) {
            var1.field25031 = var1.field25031 + field26573 * var0.field19847 * field26574;
            var1.field25026 = var1.field25026 + field26575 * var0.field19847 * field26576;
         } else if (var0.field19842) {
            var1.field25031 = 0.0;
         }

         var1.field25031 = ItemAnimationMath.method00520(var1.field25031, 0.0, 1.0);
         double var30 = var0.field19842 ? var1.field25019 : var1.field25017;
         if (!var0.field19842) {
            ;
         }

         if (var7 > field26577) {
            var1.field25063 = var1.field25063 + var7 * field26578 * var0.field19847 * field26579;
         }

         if (PlayerAnimationUtils.method09059(var2)) {
            var1.field25009 = var1.field25009 + field26580 * var0.field19847 * field26581;
         } else {
            var1.field25009 = var1.field25009 - field26582 * var0.field19847 * field26583;
         }

         var1.field25009 = ItemAnimationMath.method00520(var1.field25009, 0.0, 1.0);
         double var34 = var1.field24991;
         ItemAnimationMath.method00521(var6, var1.field24991 * var18, var1.field24992, var1.field24993);
         var1.field25064 = var1.field25064 + var0.field19845 * var0.field19847 * field26584;
         if (!var10) {
            ItemAnimationMath.method00517(var6, field26585);
         } else {
            ItemAnimationMath.method00517(var6, field26586);
         }

         if (var16 && var0.field19842 && ItemFeatureProperties.method05419(PlayerAnimationUtils.method09055(var2))) {
            var1.field25013 = var1.field25013 + field26587 * var0.field19847 * field26588;
         } else if (var16) {
            var1.field25013 = var1.field25013 - field26589 * var0.field19847 * field26590;
         }

         var1.field25013 = ItemAnimationMath.method00520(var1.field25013, 0.0, 1.0);
         if (var0.field19857 && var0.field19842 && var1.field25057 == 0.0) {
            var1.field25060 = 0.0;
         }

         var1.field25060 = var1.field25060 + field26591 * var0.field19847 * field26592;
         var1.field25060 = ItemAnimationMath.method00520(var1.field25060, 0.0, 1.0);
         if (var0.field19842) {
            double var36 = ItemAnimationMath.method00526(ItemAnimationMath.method00520(var1.field25060, 0.0, field26593) * field26594) * var1.field25102;
            double var38 = ItemAnimationMath.method00526(ItemAnimationMath.method00520(var1.field25060, 0.0, field26595) * field26596) * var1.field25102;
            var36 = AnimationCurveMath.method08367(var36);
            if (var3.equals(field26597) && var1.field25036 > field26598) {
               ItemAnimationMath.method00521(var6, 0.0, field26599 * var38, field26600 * var38);
               ItemAnimationMath.method00511(var6, field26601 * var38, field26602 * var18, field26603, 0.0);
               ItemAnimationMath.method00511(var6, field26604 * var36, field26605 * var18, field26606, 0.0);
               ItemAnimationMath.method00521(var6, 0.0, field26607 * var38, field26608 * var38);
            } else {
               if (var3.equals(field26609)) {
                  ItemAnimationMath.method00527(var6, field26610 * var38);
               }

               ItemAnimationMath.method00521(var6, 0.0 * var38, 0.0, field26611 * var38);
               ItemAnimationMath.method00508(var6, field26612 * var18 * var38, field26613 * var18, field26614, 0.0);
               ItemAnimationMath.method00511(var6, field26615 * var38, field26616 * var18, field26617, 0.0);
               ItemAnimationMath.method00509(var6, field26618 * var18 * var38, field26619 * var18, field26620, 0.0);
               ItemAnimationMath.method00509(var6, field26621 * var18 * var36, field26622 * var18, field26623, 0.0);
               ItemAnimationMath.method00511(var6, field26624 * var36, field26625 * var18, field26626, 0.0);
               ItemAnimationMath.method00508(var6, field26627 * var18 * var36, field26628 * var18, field26629, 0.0);
               if (var3.equals(field26630)) {
                  ItemAnimationMath.method00527(var6, field26631 * var36);
               }

               ItemAnimationMath.method00521(var6, 0.0 * var36, 0.0, field26632 * var36);
            }
         }

         if (var0.field19858) {
            var1.field25061 = 0.0;
         }

         var1.field25061 = var1.field25061 + field26633 * var0.field19847 * field26634;
         var1.field25061 = ItemAnimationMath.method00520(var1.field25061, 0.0, 1.0);
         if (!var0.field19842 && var1.field25055 == 0.0) {
            double var103 = ItemAnimationMath.method00526(ItemAnimationMath.method00520(var1.field25061, 0.0, field26635) * field26636) * var1.field25103;
            double var106 = ItemAnimationMath.method00526(ItemAnimationMath.method00520(var1.field25061, 0.0, field26637) * field26638) * var1.field25103;
            var103 = AnimationCurveMath.method08367(var103);
            if (var3.equals(field26639)) {
               ItemAnimationMath.method00527(var6, field26640 * var106);
            }

            ItemAnimationMath.method00521(var6, 0.0 * var106, 0.0, field26641 * var106);
            ItemAnimationMath.method00508(var6, field26642 * var106 * var18, field26643 * var18, field26644, 0.0);
            ItemAnimationMath.method00511(var6, field26645 * var106, field26646 * var18, field26647, 0.0);
            ItemAnimationMath.method00509(var6, field26648 * var106 * var18, field26649 * var18, field26650, 0.0);
            ItemAnimationMath.method00509(var6, field26651 * var103 * var18, field26652 * var18, field26653, 0.0);
            ItemAnimationMath.method00511(var6, field26654 * var103, field26655 * var18, field26656, 0.0);
            ItemAnimationMath.method00508(var6, field26657 * var103 * var18, field26658 * var18, field26659, 0.0);
            if (var3.equals(field26660)) {
               ItemAnimationMath.method00527(var6, field26661 * var106);
            }

            ItemAnimationMath.method00521(var6, 0.0 * var103, 0.0, field26662 * var103);
         }

         if (!PlayerAnimationUtils.method09057(var2) && var0.field19851 == 0.0F && var0.field19842) {
            var1.field24998 = false;
         } else if (var0.field19842 && var0.field19851 == 0.0F) {
            var1.field24998 = true;
         }

         if (var1.field25000 != var0.field19853 && var0.field19842) {
            var1.field24999 = !var1.field24999;
         }

         if (PlayerAnimationUtils.method09054(var2) && var7 > field26663) {
            var1.field25059 = var1.field25059 + var7 * var0.field19847 * field26664;
         }

         if (PlayerAnimationUtils.method09053(var2) > field26665) {
            var1.field25014 = var1.field25014 + field26666 * var0.field19847 * field26667;
         } else {
            var1.field25014 = var1.field25014 - field26668 * var0.field19847 * field26669;
         }

         var1.field25014 = ItemAnimationMath.method00520(var1.field25014, 0.0, 1.0);
         double var105 = var1.field25068;
         double var107 = var1.field25067;
         double var40 = var1.field25071;
         double var42 = var1.field25070;
         if (var4 && var3.equals(field26670) && var5 == var0.field19841 && var0.field19842 && ItemFeatureProperties.method05405(var0.field19838).field21157) {
            ItemFeatureFlags var44 = ItemFeatureProperties.method05405(var0.field19838);
            var1.field25065 = var1.field25065 + field26671 * var0.field19847 * field26672;
            if (!var44.field21159) {
               var1.field25067 = var1.field25067 + field26673 * var0.field19847 * field26674;
            }

            if (!var44.field21158) {
               var1.field25068 = var1.field25068 + field26675 * var0.field19847 * field26676;
            }

            if (var44.field21160) {
               var1.field25072 = var1.field25072 + field26677 * var0.field19847 * field26678;
            }

            if (var1.field25072 > 0.0) {
               var1.field25072 = var1.field25072 + field26679 * var0.field19847 * field26680;
            }
         } else if (var0.field19842) {
            var1.field25065 = var1.field25065 - field26681 * var0.field19847 * field26682;
            var1.field25067 = 0.0;
            var1.field25068 = 0.0;
            var1.field25066 = 0.0;
            var1.field25072 = 0.0;
         }

         if (var1.field25072 >= 1.0) {
            var1.field25072 = 0.0;
         }

         var1.field25065 = ItemAnimationMath.method00520(var1.field25065, 0.0, 1.0)
            * ItemAnimationMath.method00520(1.0 - ItemAnimationMath.method00520(var24 * field26683, 0.0, 1.0), 0.0, 1.0);
         var1.field25067 = ItemAnimationMath.method00520(var1.field25067, 0.0, 1.0);
         var1.field25068 = ItemAnimationMath.method00520(var1.field25068, 0.0, 1.0);
         if (var4 && var3.equals(field26684) && var5 == var0.field19841 && !var0.field19842 && ItemFeatureProperties.method05405(var0.field19838).field21157) {
            ItemFeatureFlags var108 = ItemFeatureProperties.method05405(var0.field19838);
            var1.field25069 = var1.field25069 + field26685 * var0.field19847 * field26686;
            if (!var108.field21159) {
               var1.field25070 = var1.field25070 + field26687 * var0.field19847 * field26688;
            }

            if (!var108.field21158) {
               var1.field25071 = var1.field25071 + field26689 * var0.field19847 * field26690;
            }
         } else if (!var0.field19842) {
            var1.field25069 = var1.field25069 - field26691 * var0.field19847 * field26692;
            var1.field25070 = 0.0;
            var1.field25071 = 0.0;
            var1.field25066 = 0.0;
         }

         var1.field25069 = ItemAnimationMath.method00520(var1.field25069, 0.0, 1.0)
            * ItemAnimationMath.method00520(1.0 - ItemAnimationMath.method00520(var24 * field26693, 0.0, 1.0), 0.0, 1.0);
         var1.field25070 = ItemAnimationMath.method00520(var1.field25070, 0.0, 1.0);
         var1.field25071 = ItemAnimationMath.method00520(var1.field25071, 0.0, 1.0);
         if (var1.field25067 == 0.0) {
            var1.field25067 = ItemAnimationMath.method00528(field26694 * var0.field19847 * field26695, var107, var1.field25067);
         }

         if (var1.field25068 == 0.0) {
            var1.field25068 = ItemAnimationMath.method00528(field26696 * var0.field19847 * field26697, var105, var1.field25068);
         }

         if (var1.field25070 == 0.0) {
            var1.field25070 = ItemAnimationMath.method00528(field26698 * var0.field19847 * field26699, var42, var1.field25070);
         }

         if (var1.field25071 == 0.0) {
            var1.field25071 = ItemAnimationMath.method00528(field26700 * var0.field19847 * field26701, var40, var1.field25071);
         }

         if (var4 && (var3.equals(field26702) || var3.equals(field26703) || var3.equals(field26704)) && var0.field19842 && var5 == var0.field19841) {
            var1.field25053 = var1.field25053 + field26705 * var0.field19847 * field26706;
         } else if (var0.field19842) {
            var1.field25053 = var1.field25053 - field26707 * var0.field19847 * field26708;
         }

         var1.field25053 = ItemAnimationMath.method00520(var1.field25053, 0.0, 1.0);
         if (var4
            && (var3.equals(field26709) || var3.equals(field26710) || var3.equals(field26711) || var3.equals(field26712))
            && var0.field19842
            && var5 == var0.field19841
            && (var1.field25053 == 1.0 || var1.field25021 > field26713)) {
            var1.field25054 = var1.field25054 + field26714 * var0.field19847 * field26715;
         }

         if (var4 && (var3.equals(field26716) || var3.equals(field26717) || var3.equals(field26718)) && !var0.field19842 && var5 == var0.field19841) {
            var1.field25055 = var1.field25055 + field26719 * var0.field19847 * field26720;
         } else if (!var0.field19842) {
            var1.field25055 = var1.field25055 - field26721 * var0.field19847 * field26722;
         }

         var1.field25055 = ItemAnimationMath.method00520(var1.field25055, 0.0, 1.0);
         if (var4
            && (var3.equals(field26723) || var3.equals(field26724) || var3.equals(field26725) || var3.equals(field26726))
            && !var0.field19842
            && var5 == var0.field19841
            && (var1.field25055 == 1.0 || var1.field25022 > field26727)) {
            var1.field25056 = var1.field25056 + field26728 * var0.field19847 * field26729;
         }

         if (var4 && var3.equals(field26730) && var0.field19842 && var5 == var0.field19841 && var1.field25053 == 1.0) {
            var1.field25057 = var1.field25057 + field26731 * var0.field19847 * field26732;
         } else if (var0.field19842) {
            var1.field25057 = var1.field25057 - field26733 * var0.field19847 * field26734;
         }

         var1.field25057 = ItemAnimationMath.method00520(var1.field25057, 0.0, 1.0);
         if (var4 && var3.equals(field26735) && !var0.field19842 && var5 == var0.field19841 && var1.field25055 == 1.0) {
            var1.field25058 = var1.field25058 + field26736 * var0.field19847 * field26737;
         } else if (!var0.field19842) {
            var1.field25058 = var1.field25058 - field26738 * var0.field19847 * field26739;
         }

         var1.field25058 = ItemAnimationMath.method00520(var1.field25058, 0.0, 1.0);
         if (var4 && var3.equals(field26740) && !var0.field19842 && var5 == var0.field19841) {
            var1.field25051 = var1.field25051 + field26741 * var0.field19847 * field26742;
         } else if (!var0.field19842) {
            var1.field25051 = var1.field25051 - field26743 * var0.field19847 * field26744;
         }

         var1.field25051 = ItemAnimationMath.method00520(var1.field25051, 0.0, 1.0);
         if (var4 && var3.equals(field26745) && !var0.field19842 && var5 == var0.field19841 && var1.field25051 == 1.0) {
            var1.field25052 = var1.field25052 + field26746 * var0.field19847 * field26747;
         } else if (!var0.field19842) {
            var1.field25052 = var1.field25052 - field26748 * var0.field19847 * field26749;
         }

         var1.field25052 = ItemAnimationMath.method00520(var1.field25052, 0.0, 1.0);
         if (var4 && var3.equals(field26750) && var0.field19842 && var5 == var0.field19841 && !var17) {
            var1.field25049 = var1.field25049 + field26751 * var0.field19847 * field26752;
         } else if (var0.field19842) {
            var1.field25049 = var1.field25049 - field26753 * var0.field19847 * field26754;
         }

         var1.field25049 = ItemAnimationMath.method00520(var1.field25049, 0.0, 1.0);
         if (var4 && var3.equals(field26755) && var0.field19842 && var5 == var0.field19841 && var1.field25049 == 1.0 && !var17) {
            var1.field25050 = var1.field25050 + field26756 * var0.field19847 * field26757;
         } else if (var0.field19842) {
            var1.field25050 = var1.field25050 - field26758 * var0.field19847 * field26759;
         }

         var1.field25050 = ItemAnimationMath.method00520(var1.field25050, 0.0, 1.0);
         ItemStack var109 = PlayerAnimationUtils.method09056(var2);
         String var45 = ItemFeatureProperties.method05406(var109);
         boolean var46 = !ItemFeatureProperties.method05417(var109);
         boolean var47 = var46
            && !var45.equals(field26760)
            && !var45.equals(field26761)
            && !var45.equals(field26762)
            && !var45.equals(field26763)
            && !var45.equals(field26764)
            && !var45.equals(field26765);
         if (!var0.field19842
            && var10
            && (!var4 || !var47)
            && !PlayerAnimationUtils.method09062(var2)
            && !PlayerAnimationUtils.method09048(var2)
            && !PlayerAnimationUtils.method09054(var2)) {
            var1.field25048 = var1.field25048 + field26766 * var0.field19847 * field26767;
         } else if (!var0.field19842 || var4 && var47 || PlayerAnimationUtils.method09062(var2) || PlayerAnimationUtils.method09054(var2)) {
            var1.field25048 = var1.field25048 - field26768 * var0.field19847 * field26769;
         }

         var1.field25048 = ItemAnimationMath.method00520(var1.field25048, 0.0, 1.0);
         if (var4 && var3.equals(field26770) && var0.field19842 && var5 == var0.field19841) {
            var1.field25021 = var1.field25021 + field26771 * var0.field19847 * field26772;
         } else if (var0.field19842) {
            var1.field25021 = var1.field25021 - field26773 * var0.field19847 * field26774;
         }

         var1.field25021 = ItemAnimationMath.method00520(var1.field25021, 0.0, 1.0) * var1.field25105;
         if (var4 && var3.equals(field26775) && !var0.field19842 && var5 == var0.field19841) {
            var1.field25022 = var1.field25022 + field26776 * var0.field19847 * field26777;
         } else if (!var0.field19842) {
            var1.field25022 = var1.field25022 - field26778 * var0.field19847 * field26779;
         }

         var1.field25022 = ItemAnimationMath.method00520(var1.field25022, 0.0, 1.0) * var1.field25105;
         if (var4 && var3.equals(field26780) && !var0.field19842 && var5 == var0.field19841) {
            var1.field25032 = var1.field25032 + field26781 * var0.field19847 * field26782;
            var1.field25034 = var1.field25034 + field26783 * var0.field19847 * field26784;
            var1.field25035 = var1.field25035 + field26785 * var0.field19847 * field26786;
         } else if (!var0.field19842) {
            if (PlayerAnimationUtils.method09038(var2)) {
               var1.field25032 = var1.field25032 - field26787 * var0.field19847 * field26788;
               var1.field25034 = var1.field25034 - field26789 * var0.field19847 * field26790;
            } else {
               var1.field25032 = var1.field25032 - field26791 * var0.field19847 * field26792;
               var1.field25034 = var1.field25034 - field26793 * var0.field19847 * field26794;
            }

            var1.field25035 = var1.field25035 - field26795 * var0.field19847 * field26796;
         }

         var1.field25032 = ItemAnimationMath.method00520(var1.field25032, 0.0, 1.0);
         var1.field25034 = ItemAnimationMath.method00520(var1.field25034, 0.0, 1.0);
         if (var4 && var3.equals(field26797) && var0.field19842 && var5 == var0.field19841) {
            var1.field25036 = var1.field25036 + field26798 * var0.field19847 * field26799;
            var1.field25033 = var1.field25033 + field26800 * var0.field19847 * field26801;
            var1.field25037 = var1.field25037 + field26802 * var0.field19847 * field26803;
         } else if (var0.field19842) {
            if (PlayerAnimationUtils.method09038(var2)) {
               var1.field25036 = var1.field25036 - field26804 * var0.field19847 * field26805;
               var1.field25033 = var1.field25033 - field26806 * var0.field19847 * field26807;
            } else {
               var1.field25036 = var1.field25036 - field26808 * var0.field19847 * field26809;
               var1.field25033 = var1.field25033 - field26810 * var0.field19847 * field26811;
            }

            var1.field25037 = var1.field25037 - field26812 * var0.field19847 * field26813;
         }

         var1.field25033 = var1.field25033 * ItemAnimationMath.method00519(field26814, var0.field19847 * field26815);
         var1.field25036 = ItemAnimationMath.method00520(var1.field25036, 0.0, 1.0);
         var1.field25033 = ItemAnimationMath.method00520(var1.field25033, 0.0, 1.0);
         if (var4 && var3.equals(field26816) && var0.field19842 && var5 == var0.field19841) {
            if (var12) {
               var1.field25038 = var1.field25038 + field26817 * var0.field19847 * field26818;
            } else {
               var1.field25038 = var1.field25038 + field26819 * var0.field19847 * field26820;
            }
         } else if (var0.field19842) {
            if (var12) {
               var1.field25038 = var1.field25038 - field26821 * var0.field19847 * field26822;
            } else {
               var1.field25038 = var1.field25038 - field26823 * var0.field19847 * field26824;
            }
         }

         var1.field25038 = var1.field25038 - var1.field25015 * field26825 * var0.field19847 * field26826;
         var1.field25038 = ItemAnimationMath.method00520(var1.field25038, 0.0, 1.0);
         if (var4 && var3.equals(field26827) && !var0.field19842 && var5 == var0.field19841) {
            var1.field25039 = var1.field25039 + field26828 * var0.field19847 * field26829;
         } else if (!var0.field19842) {
            var1.field25039 = var1.field25039 - field26830 * var0.field19847 * field26831;
         }

         var1.field25039 = var1.field25039 - var1.field25015 * field26832 * var0.field19847 * field26833;
         var1.field25039 = ItemAnimationMath.method00520(var1.field25039, 0.0, 1.0);
         if (var7 > field26834 && ItemAnimationMath.method00514(PlayerAnimationUtils.method09044(var2)) < field26835 && PlayerAnimationUtils.method09057(var2)) {
            var1.field25040 = var1.field25040 + var7 * var0.field19847 * field26836;
            var1.field25041 = var1.field25041 + field26837 * var0.field19847 * field26838;
         } else {
            var1.field25041 = var1.field25041 - field26839 * var0.field19847 * field26840;
         }

         var1.field25041 = ItemAnimationMath.method00520(var1.field25041, 0.0, 1.0);
         var1.field25043 = var1.field25043
            + (
                  field26841 * PlayerAnimationUtils.method09044(var2)
                     + ItemAnimationMath.method00526(var1.field25044 * field26842) * field26843
                     + ItemAnimationMath.method00526(var1.field25030 * field26844) * field26845
                     + ItemAnimationMath.method00526(var1.field25028 * field26846) * field26847
               )
               * field26848
               * var0.field19847
               * field26849;
         var1.field25043 = var1.field25043 - field26850 * var1.field25042 * var0.field19847 * field26851;
         var1.field25043 = var1.field25043 * ItemAnimationMath.method00519(field26852, var0.field19847 * field26853);
         var1.field25042 = var1.field25042 + var1.field25043 * var0.field19847 * field26854;
         if (PlayerAnimationUtils.method09052(var2)) {
            var1.field25044 = var1.field25044 + field26855 * var0.field19847 * field26856;
         } else {
            var1.field25044 = var1.field25044 - field26857 * var0.field19847 * field26858;
         }

         var1.field25044 = ItemAnimationMath.method00520(var1.field25044, 0.0, 1.0);
         ItemAnimationMath.method00527(var6, field26859 * var1.field25044);
         ItemAnimationMath.method00511(var6, field26860 * ItemAnimationMath.method00526(var1.field25044 * field26861), 0.0, field26862, 0.0);
         var1.field25045 = var1.field25045 + field26863 * var0.field19847 * field26864;
         if (PlayerAnimationUtils.method09062(var2)) {
            var1.field25046 = var1.field25046 + field26865 * var0.field19847 * field26866;
         } else {
            var1.field25046 = var1.field25046 - field26867 * var0.field19847 * field26868;
         }

         if (var1.field25046 > 1.0) {
            var1.field25046 = 1.0;
         }

         if (var1.field25046 < 0.0) {
            var1.field25046 = 0.0;
         }

         if (PlayerAnimationUtils.method09054(var2)) {
            var1.field25023 = var1.field25023 + field26869 * var0.field19847 * field26870;
         } else {
            var1.field25023 = var1.field25023 - field26871 * var0.field19847 * field26872;
         }

         var1.field25023 = ItemAnimationMath.method00520(var1.field25023, 0.0, 1.0);
         if (PlayerAnimationUtils.method09054(var2) && var7 > field26873) {
            var1.field25024 = var1.field25024 + field26874 * var0.field19847 * field26875;
         } else {
            var1.field25024 = var1.field25024 - field26876 * var0.field19847 * field26877;
         }

         var1.field25024 = ItemAnimationMath.method00520(var1.field25024, 0.0, 1.0);
         if (PlayerAnimationUtils.method09062(var2) && ItemAnimationMath.method00514(PlayerAnimationUtils.method09044(var2)) > field26878) {
            if (PlayerAnimationUtils.method09044(var2) > 0.0) {
               var1.field25047 = var1.field25047 + PlayerAnimationUtils.method09044(var2) * var0.field19847 * field26879;
            } else {
               var1.field25047 = var1.field25047 + PlayerAnimationUtils.method09044(var2) / field26880 * var0.field19847 * field26881;
            }
         }

         if (PlayerAnimationUtils.method09048(var2) && !var4) {
            var1.field25062 = var1.field25062 + var7 * var0.field19847 * field26882;
            var1.field25025 = var1.field25025 + field26883 * var0.field19847 * field26884;
         } else {
            var1.field25025 = var1.field25025 - field26885 * var0.field19847 * field26886;
         }

         var1.field25025 = ItemAnimationMath.method00520(var1.field25025, 0.0, 1.0);
         ItemAnimationMath.method00517(var6, field26887 * ItemAnimationMath.method00526(var1.field25062 * field26888) * var1.field25025 * var1.field25106);
         if (!var14 && !var15) {
            ItemAnimationMath.method00511(var6, PlayerAnimationUtils.method09053(var2) * field26892 + var30 * field26893, 0.0, field26894, 0.0);
         } else {
            ItemAnimationMath.method00511(var6, PlayerAnimationUtils.method09053(var2) * field26889 + var30 * field26890, 0.0, field26891, 0.0);
         }

         if (var10) {
            ItemAnimationMath.method00521(
               var6,
               0.0,
               field26895 * -ItemAnimationMath.method00525(var1.field25062 * field26896) * var1.field25025 + field26897 * var1.field25025 * var1.field25106,
               0.0
            );
            ItemAnimationMath.method00508(
               var6,
               field26898 * var18 * ItemAnimationMath.method00525(var1.field25062 * field26899) * var1.field25025 * var1.field25106,
               field26900 * var18,
               field26901,
               0.0
            );
            ItemAnimationMath.method00511(
               var6,
               field26902 * ItemAnimationMath.method00525(var1.field25062 * field26903) * var1.field25025 * var1.field25106,
               field26904 * var18,
               field26905,
               0.0
            );
            ItemAnimationMath.method00511(var6, field26906 * var1.field25025 * var1.field25106, field26907 * var18, field26908, 0.0);
            ItemAnimationMath.method00509(
               var6,
               field26909 * var18 * ItemAnimationMath.method00526(var1.field25062 * field26910) * var1.field25025 * var1.field25106,
               field26911 * var18,
               field26912,
               0.0
            );
         } else {
            ItemAnimationMath.method00508(
               var6,
               field26913 * var18 * ItemAnimationMath.method00525(var1.field25062 * field26914) * var1.field25025 * var1.field25106,
               field26915 * var18,
               field26916,
               0.0
            );
            ItemAnimationMath.method00511(
               var6,
               field26917 * ItemAnimationMath.method00525(var1.field25062 * field26918) * var1.field25025 * var1.field25106,
               field26919 * var18,
               field26920,
               0.0
            );
         }

         if (!ItemFeatureProperties.method05404(var0.field19838, Items.BELL)
            && !ItemFeatureProperties.method05408(var0.field19838)
            && !ItemFeatureProperties.method05420(var0.field19838, ItemTagAliases.field23898)
            && !ItemFeatureProperties.method05404(var0.field19838, Items.PINK_PETALS)
            && !ItemFeatureProperties.method05404(var0.field19838, Items.LEAF_LITTER)
            && !ItemFeatureProperties.method05404(var0.field19838, Items.WILDFLOWERS)
            && !ItemFeatureProperties.method05404(var0.field19838, Items.END_CRYSTAL)
            && !ItemFeatureProperties.method05404(var0.field19838, Items.PAINTING)
            && !ItemFeatureProperties.method05404(var0.field19838, Items.ITEM_FRAME)) {
            if (!var10 && !var3.equals(field26928)) {
               ItemAnimationMath.method00527(var6, field26929);
               ItemAnimationMath.method00524(var6, field26930 * var18);
               ItemAnimationMath.method00513(var6, field26931);
            }
         } else if (ItemFeatureProperties.method05404(var0.field19838, Items.PINK_PETALS)
            || ItemFeatureProperties.method05404(var0.field19838, Items.LEAF_LITTER)
            || ItemFeatureProperties.method05404(var0.field19838, Items.WILDFLOWERS)) {
            ItemAnimationMath.method00521(var6, 0.0, field26921, field26922);
         } else if (ItemFeatureProperties.method05404(var0.field19838, Items.END_CRYSTAL)) {
            ItemAnimationMath.method00517(var6, field26923);
            ItemAnimationMath.method00513(var6, field26924);
         } else {
            ItemAnimationMath.method00521(var6, 0.0, field26925, field26926);
            ItemAnimationMath.method00513(var6, field26927);
         }

         ItemAnimationMath.method00527(var6, field26932 * ItemAnimationMath.method00526(var1.field25045));
         ItemAnimationMath.method00511(var6, field26933 * var18 * ItemAnimationMath.method00525(var1.field25045), field26934 * var18, field26935, 0.0);
         ItemAnimationMath.method00508(var6, field26936 * var18 * ItemAnimationMath.method00526(var1.field25045) * var18, field26937 * var18, field26938, 0.0);
         ItemAnimationMath.method00509(
            var6, field26939 * var18 * ItemAnimationMath.method00526(var1.field25045 * field26940) * var18, field26941 * var18, field26942, 0.0
         );
         if (var10 && !var0.field19842) {
            ItemAnimationMath.method00521(
               var6, 0.0, field26943 * AnimationCurveMath.method08355(var1.field25048), field26944 * AnimationCurveMath.method08355(var1.field25048)
            );
         }

         double var48;
         if (!var10 && !var11) {
            var48 = 1.0;
         } else {
            var48 = field26945;
         }

         if (var10) {
            ItemAnimationMath.method00517(var6, field26946 * (var1.field25042 * var48));
         }

         ItemAnimationMath.method00511(var6, field26947 * (var1.field25042 * var48), 0.0, field26948, 0.0);
         ItemAnimationMath.method00527(var6, field26949 * var1.field25042 * var48);
         double var50 = var0.field19843 ? var1.field25040 : var1.field25040 - field26950;
         ItemAnimationMath.method00511(var6, field26951 * ItemAnimationMath.method00526(var50) * var1.field25041, 0.0, field26952, 0.0);
         ItemAnimationMath.method00508(
            var6, field26953 * ItemAnimationMath.method00525(var1.field25040 * field26954) * var1.field25041 * var18, 0.0, field26955, 0.0
         );
         ItemAnimationMath.method00509(
            var6, 1.0 * ItemAnimationMath.method00525(var1.field25040 * field26956) * var1.field25041 * var18, 0.0, field26957, 0.0
         );
         if (var3.equals(field26958) && !var12) {
            ItemAnimationMath.method00521(var6, field26959 * var18, 0.0, field26960);
            ItemAnimationMath.method00508(var6, field26961 * var18, field26962 * var18, field26963, 0.0);
         }

         if (var3.equals(field26964) && var0.field19842) {
            ItemAnimationMath.method00521(
               var6,
               -var34 * var18 * AnimationCurveMath.method08367(var1.field25038)
                  + field26965 * var18 * AnimationCurveMath.method08367(var1.field25038) * var1.field25104,
               0.0,
               0.0
            );
            if (var12) {
               ItemAnimationMath.method00508(
                  var6, field26966 * AnimationCurveMath.method08367(var1.field25038) * var18 * var1.field25104, field26967 * var18, field26968, 0.0
               );
            } else {
               ItemAnimationMath.method00508(
                  var6, field26969 * AnimationCurveMath.method08367(var1.field25038) * var18 * var1.field25104, field26970 * var18, field26971, 0.0
               );
            }

            ItemAnimationMath.method00511(
               var6,
               field26972 * ItemAnimationMath.method00520(ItemAnimationMath.method00526(var1.field25038 * field26973), 0.0, 1.0) * var1.field25104,
               field26974 * var18,
               field26975,
               0.0
            );
            ItemAnimationMath.method00511(
               var6, field26976 * AnimationCurveMath.method08367(var1.field25038) * var1.field25104, field26977 * var18, field26978, 0.0
            );
         }

         if (var3.equals(field26979) && !var0.field19842) {
            ItemAnimationMath.method00521(
               var6,
               -var34 * var18 * AnimationCurveMath.method08367(var1.field25039)
                  + field26980 * var18 * AnimationCurveMath.method08367(var1.field25039) * var1.field25104,
               0.0,
               0.0
            );
            if (var12) {
               ItemAnimationMath.method00508(
                  var6, field26981 * AnimationCurveMath.method08367(var1.field25039) * var18 * var1.field25104, field26982 * var18, field26983, 0.0
               );
            } else {
               ItemAnimationMath.method00508(
                  var6, field26984 * AnimationCurveMath.method08367(var1.field25039) * var18 * var1.field25104, field26985 * var18, field26986, 0.0
               );
            }

            ItemAnimationMath.method00511(
               var6,
               field26987 * ItemAnimationMath.method00520(ItemAnimationMath.method00526(var1.field25039 * field26988), 0.0, 1.0) * var1.field25104,
               field26989 * var18,
               field26990,
               0.0
            );
            ItemAnimationMath.method00511(
               var6, field26991 * AnimationCurveMath.method08367(var1.field25039) * var1.field25104, field26992 * var18, field26993, 0.0
            );
         }

         double var52 = AnimationCurveMath.method08375(var1.field25036);
         if (var3.equals(field26994) && var0.field19842) {
            ItemAnimationMath.method00521(var6, 0.0, field26995 * var52 * var1.field25100, field26996 * var52 * var1.field25100);
            ItemAnimationMath.method00511(var6, field26997 * var52, field26998 * var18 * var1.field25100, field26999, 0.0);
            ItemAnimationMath.method00511(var6, field27000 * var1.field25033 * var1.field25100, field27001 * var18, field27002, 0.0);
            ItemAnimationMath.method00509(var6, field27003 * var18 * var52 * var1.field25100, field27004 * var18, field27005, 0.0);
            ItemAnimationMath.method00511(
               var6, field27006 * ItemAnimationMath.method00526(var1.field25037 * var52 * field27007) * var1.field25100, field27008 * var18, field27009, 0.0
            );
         }

         if (!var0.field19842) {
            if (var10) {
               ItemAnimationMath.method00527(var6, field27010 * var52 * var1.field25100);
            } else {
               ItemAnimationMath.method00527(var6, field27011 * var52 * var1.field25100);
            }

            ItemAnimationMath.method00521(var6, field27012 * var18 * var52 * var1.field25100, 0.0, field27013 * var52 * var1.field25100);
            ItemAnimationMath.method00508(var6, field27014 * var18 * var52 * var1.field25100, field27015 * var18, field27016, 0.0);
            ItemAnimationMath.method00511(var6, field27017 * var52 * var1.field25100, field27018 * var18, field27019, 0.0);
         }

         double var54 = AnimationCurveMath.method08375(var1.field25032);
         if (var3.equals(field27020) && !var0.field19842) {
            ItemAnimationMath.method00521(var6, 0.0, field27021 * var54 * var1.field25100, field27022 * var54 * var1.field25100);
            ItemAnimationMath.method00511(var6, field27023 * var54 * var1.field25100, field27024 * var18, field27025, 0.0);
            ItemAnimationMath.method00509(var6, field27026 * var18 * var54 * var1.field25100, field27027 * var18, field27028, 0.0);
            ItemAnimationMath.method00511(
               var6, field27029 * ItemAnimationMath.method00526(var1.field25035 * var54 * field27030) * var1.field25100, field27031 * var18, field27032, 0.0
            );
         }

         if (var0.field19842) {
            if (var10) {
               ItemAnimationMath.method00527(var6, field27033 * var54 * var1.field25100);
            } else {
               ItemAnimationMath.method00527(var6, field27034 * var54 * var1.field25100);
            }

            ItemAnimationMath.method00521(var6, field27035 * var18 * var54 * var1.field25100, 0.0, field27036 * var54 * var1.field25100);
            ItemAnimationMath.method00508(var6, field27037 * var18 * var54 * var1.field25100, field27038 * var18, field27039, 0.0);
            ItemAnimationMath.method00511(var6, field27040 * var54 * var1.field25100, field27041 * var18, field27042, 0.0);
         }

         double var56 = ItemAnimationMath.method00526(var0.field19845 * field27043);
         double var58 = ItemAnimationMath.method00520(ItemAnimationMath.method00526(var0.field19845 * field27044), 0.0, 1.0);
         double var60 = ItemAnimationMath.method00526(var0.field19845 * field27045);
         if (var10) {
            ItemAnimationMath.method00521(
               var6,
               field27046 * var18 * var24 * var1.field25091,
               field27047 * var60 + field27048 * var24 + field27049 * var20 + field27050 * var58 * var1.field25091,
               field27051 * var60 - field27052 * var26 - field27053 * var24 * var1.field25091
            );
            ItemAnimationMath.method00513(var6, field27054 * var58 * var1.field25091);
            ItemAnimationMath.method00517(var6, field27055 * var20 * var1.field25091);
            ItemAnimationMath.method00511(var6, field27056 * var24 * var1.field25091, field27057 * var18, field27058, 0.0);
            ItemAnimationMath.method00511(var6, field27059 * var26, field27060 * var18 * var1.field25091, field27061, 0.0);
            ItemAnimationMath.method00511(var6, field27062 * var20, field27063 * var18 * var1.field25091, field27064, 0.0);
            ItemAnimationMath.method00509(var6, field27065 * var18 * var24, field27066 * var18 * var1.field25091, field27067, 0.0);
            ItemAnimationMath.method00508(var6, field27068 * var18 * var24, field27069 * var18 * var1.field25091, field27070, 0.0);
            ItemAnimationMath.method00511(var6, field27071 * var60, field27072 * var18 * var1.field25091, field27073, 0.0);
            ItemAnimationMath.method00509(var6, field27074 * var18 * var60, field27075 * var18 * var1.field25091, field27076, 0.0);
            ItemAnimationMath.method00508(var6, field27077 * var18 * var60, field27078 * var18 * var1.field25091, field27079, 0.0);
            ItemAnimationMath.method00508(var6, field27080 * var18 * var26, field27081 * var18 * var1.field25091, field27082, 0.0);
         } else if (var13) {
            ItemAnimationMath.method00517(var6, field27083 * var22 * var1.field25093);
            ItemAnimationMath.method00517(var6, 0.0 * var26 * var1.field25093);
            ItemAnimationMath.method00517(var6, 0.0 * var28 * var1.field25093);
            ItemAnimationMath.method00527(var6, 0.0 * var26 * var1.field25093);
            ItemAnimationMath.method00527(var6, field27084 * var60 * var1.field25093);
            ItemAnimationMath.method00529(var6, field27085 * var18 * var26 * var1.field25093);
            ItemAnimationMath.method00529(var6, field27086 * var18 * var28 * var1.field25093);
            ItemAnimationMath.method00517(var6, field27087 * var56 * var1.field25093);
            ItemAnimationMath.method00527(var6, field27088 * var56 * var1.field25093);
            ItemAnimationMath.method00529(var6, field27089 * var18 * var56 * var1.field25093);
            ItemAnimationMath.method00511(var6, field27090 * var22 * var1.field25093, field27091 * var18, field27092, 0.0);
            ItemAnimationMath.method00511(var6, field27093 * var22 * var1.field25093, field27094 * var18, field27095, 0.0);
            ItemAnimationMath.method00511(var6, field27096 * var58 * var1.field25093, field27097 * var18, field27098, 0.0);
            ItemAnimationMath.method00511(var6, field27099 * var20 * var1.field25093, field27100 * var18, field27101, 0.0);
            ItemAnimationMath.method00511(var6, field27102 * var26 * var1.field25093, field27103 * var18, field27104, 0.0);
            ItemAnimationMath.method00511(var6, field27105 * var28 * var1.field25093, field27106 * var18, field27107, 0.0);
            ItemAnimationMath.method00511(var6, field27108 * var56 * var1.field25093, field27109 * var18, field27110, 0.0);
            ItemAnimationMath.method00508(var6, field27111 * var56 * var18 * var1.field25093, field27112 * var18, field27113, 0.0);
            ItemAnimationMath.method00509(
               var6,
               ItemAnimationMath.method00520(field27114 * var18 * ItemAnimationMath.method00526(var1.field25064) * var24, field27115, field27116)
                  * var1.field25093,
               field27117 * var18,
               field27118,
               0.0
            );
         } else if (!var12 && !var15 && !var3.equals(field27119) && !var3.equals(field27120) && !var14) {
            if (ItemFeatureProperties.method05420(var0.field19838, ItemTagAliases.field23897)) {
               ItemAnimationMath.method00527(var6, field27301 * var22);
               ItemAnimationMath.method00517(var6, field27302 * var22);
               ItemAnimationMath.method00517(var6, field27303 * var56);
               ItemAnimationMath.method00527(var6, field27304 * var56);
               ItemAnimationMath.method00527(var6, field27305 * var20);
               ItemAnimationMath.method00517(var6, field27306 * var20);
               ItemAnimationMath.method00527(var6, field27307 * var28);
               ItemAnimationMath.method00513(var6, field27308 * var22);
               ItemAnimationMath.method00513(var6, field27309 * var56);
               ItemAnimationMath.method00513(var6, field27310 * var20);
               ItemAnimationMath.method00513(var6, field27311 * var28);
               ItemAnimationMath.method00513(var6, field27312 * var58);
               ItemAnimationMath.method00513(var6, field27313 * var60);
            } else {
               ItemAnimationMath.method00517(var6, field27314 * var24);
               ItemAnimationMath.method00529(var6, field27315 * var18 * var24);
               ItemAnimationMath.method00517(var6, field27316 * var58);
               ItemAnimationMath.method00517(var6, field27317 * var26);
               ItemAnimationMath.method00527(var6, field27318 * var26);
               ItemAnimationMath.method00527(var6, 0.0 * var24);
               ItemAnimationMath.method00511(var6, field27319 * var20, field27320 * var18, field27321, 0.0);
               ItemAnimationMath.method00511(var6, field27322 * var26, field27323 * var18, field27324, 0.0);
               ItemAnimationMath.method00511(var6, field27325 * var58, field27326 * var18, field27327, 0.0);
               ItemAnimationMath.method00524(var6, field27328 * var18 * var56);
               ItemAnimationMath.method00512(var6, field27329 * var18 * var56);
               ItemAnimationMath.method00511(var6, field27330 * var60, field27331 * var18, field27332, 0.0);
               ItemAnimationMath.method00509(var6, field27333 * var18 * var60, field27334 * var18, field27335, 0.0);
               ItemAnimationMath.method00508(var6, field27336 * var18 * var60, field27337 * var18, field27338, 0.0);
            }
         } else if (var1.field24998 && var1.field24999 && !var0.field19860 && var12) {
            ItemAnimationMath.method00517(var6, field27121 * var22 * var1.field25092);
            ItemAnimationMath.method00529(var6, field27122 * var18 * var22 * var1.field25092);
            ItemAnimationMath.method00527(var6, field27123 * var22 * var1.field25092);
            ItemAnimationMath.method00517(var6, field27124 * var26 * var1.field25092);
            ItemAnimationMath.method00517(var6, 0.0 * var28 * var1.field25092);
            ItemAnimationMath.method00527(var6, 0.0 * var26 * var1.field25092);
            ItemAnimationMath.method00527(var6, field27125 * var60 * var1.field25092);
            ItemAnimationMath.method00529(var6, field27126 * var18 * var26 * var1.field25092);
            ItemAnimationMath.method00529(var6, field27127 * var18 * var28 * var1.field25092);
            ItemAnimationMath.method00517(var6, field27128 * var56 * var1.field25092);
            ItemAnimationMath.method00527(var6, field27129 * var56 * var1.field25092);
            ItemAnimationMath.method00529(var6, field27130 * var18 * var56 * var1.field25092);
            ItemAnimationMath.method00511(var6, field27131 * var22 * var1.field25092, field27132 * var18, field27133, 0.0);
            ItemAnimationMath.method00509(var6, field27134 * var18 * var22 * var1.field25092, field27135 * var18, field27136, 0.0);
            ItemAnimationMath.method00511(var6, field27137 * var22 * var1.field25092, field27138 * var18, field27139, 0.0);
            ItemAnimationMath.method00511(var6, field27140 * var58 * var1.field25092, field27141 * var18, field27142, 0.0);
            ItemAnimationMath.method00511(var6, field27143 * var20 * var1.field25092, field27144 * var18, field27145, 0.0);
            ItemAnimationMath.method00511(var6, field27146 * var26 * var1.field25092, field27147 * var18, field27148, 0.0);
            ItemAnimationMath.method00511(var6, field27149 * var28 * var1.field25092, field27150 * var18, field27151, 0.0);
            ItemAnimationMath.method00511(var6, field27152 * var56 * var1.field25092, field27153 * var18, field27154, 0.0);
         } else if ((!var1.field24998 || var0.field19860 || !var12) && !var3.equals(field27155) && !var3.equals(field27156)) {
            if ((!var1.field24998 || var0.field19860) && var12 || var15 || var14 || var0.field19860 && var3.equals(field27221)) {
               ItemAnimationMath.method00517(var6, field27222 * var22);
               ItemAnimationMath.method00517(var6, 0.0 * var26);
               ItemAnimationMath.method00517(var6, 0.0 * var28);
               ItemAnimationMath.method00527(var6, 0.0 * var26);
               ItemAnimationMath.method00527(var6, field27223 * var60);
               ItemAnimationMath.method00529(var6, field27224 * var18 * var26);
               ItemAnimationMath.method00529(var6, field27225 * var18 * var28);
               ItemAnimationMath.method00517(var6, field27226 * var56);
               ItemAnimationMath.method00527(var6, field27227 * var56);
               ItemAnimationMath.method00529(var6, field27228 * var18 * var56);
               ItemAnimationMath.method00511(var6, field27229 * var22, field27230 * var18, field27231, 0.0);
               if (var14 && var0.field19860) {
                  ItemAnimationMath.method00509(var6, field27232 * var18 * var22, field27233 * var18, field27234, 0.0);
               } else {
                  ItemAnimationMath.method00509(var6, field27235 * var18 * var22, field27236 * var18, field27237, 0.0);
               }

               ItemAnimationMath.method00511(var6, field27238 * var22, field27239 * var18, field27240, 0.0);
               ItemAnimationMath.method00511(var6, field27241 * var58, field27242 * var18, field27243, 0.0);
               ItemAnimationMath.method00511(var6, field27244 * var20, field27245 * var18, field27246, 0.0);
               ItemAnimationMath.method00511(var6, field27247 * var26, field27248 * var18, field27249, 0.0);
               ItemAnimationMath.method00511(var6, field27250 * var28, field27251 * var18, field27252, 0.0);
               ItemAnimationMath.method00511(var6, field27253 * var56, field27254 * var18, field27255, 0.0);
               ItemAnimationMath.method00524(
                  var6,
                  ItemAnimationMath.method00520(field27256 * var18 * ItemAnimationMath.method00526(var1.field25064 * field27257) * var24, 0.0, field27258)
               );
               ItemAnimationMath.method00527(var6, field27259 * ItemAnimationMath.method00526(var1.field25064 * field27260) * var24);
            } else {
               ItemAnimationMath.method00517(var6, field27261 * var24);
               ItemAnimationMath.method00529(var6, field27262 * var18 * var24);
               ItemAnimationMath.method00517(var6, field27263 * var58);
               ItemAnimationMath.method00517(var6, field27264 * var26);
               ItemAnimationMath.method00527(var6, field27265 * var26);
               ItemAnimationMath.method00527(var6, field27266 * var24);
               ItemAnimationMath.method00511(var6, field27267 * var20, field27268 * var18, field27269, 0.0);
               ItemAnimationMath.method00511(var6, field27270 * var26, field27271 * var18, field27272, 0.0);
               ItemAnimationMath.method00511(var6, field27273 * var26, field27274 * var18, field27275, 0.0);
               ItemAnimationMath.method00511(var6, field27276 * var58, field27277 * var18, field27278, 0.0);
               ItemAnimationMath.method00524(var6, field27279 * var18 * var56);
               ItemAnimationMath.method00512(var6, field27280 * var18 * var56);
               if (var12) {
                  ItemAnimationMath.method00517(var6, field27281 * var28);
                  ItemAnimationMath.method00517(var6, field27282 * var56);
                  ItemAnimationMath.method00512(var6, field27283 * var18 * var56);
                  ItemAnimationMath.method00513(var6, field27284 * var28);
                  ItemAnimationMath.method00513(var6, field27285 * var56);
                  ItemAnimationMath.method00513(var6, field27286 * var22);
               }

               if (!var12) {
                  ItemAnimationMath.method00511(var6, field27287 * var60, field27288 * var18, field27289, 0.0);
               }

               ItemAnimationMath.method00509(var6, field27290 * var18 * var60, field27291 * var18, field27292, 0.0);
               ItemAnimationMath.method00508(var6, field27293 * var18 * var60, field27294 * var18, field27295, 0.0);
               ItemAnimationMath.method00524(
                  var6,
                  ItemAnimationMath.method00520(field27296 * var18 * ItemAnimationMath.method00526(var1.field25064 * field27297) * var24, 0.0, field27298)
               );
               ItemAnimationMath.method00527(var6, field27299 * ItemAnimationMath.method00526(var1.field25064 * field27300) * var24);
            }
         } else if (var12) {
            ItemAnimationMath.method00517(var6, field27157 * var22 * var1.field25092);
            ItemAnimationMath.method00517(var6, field27158 * var26 * var1.field25092);
            ItemAnimationMath.method00517(var6, field27159 * var28 * var1.field25092);
            ItemAnimationMath.method00527(var6, field27160 * var26 * var1.field25092);
            ItemAnimationMath.method00527(var6, field27161 * var60 * var1.field25092);
            ItemAnimationMath.method00529(var6, field27162 * var18 * var26 * var1.field25092);
            ItemAnimationMath.method00529(var6, field27163 * var18 * var28 * var1.field25092);
            ItemAnimationMath.method00517(var6, field27164 * var56 * var1.field25092);
            ItemAnimationMath.method00527(var6, field27165 * var56 * var1.field25092);
            ItemAnimationMath.method00529(var6, field27166 * var18 * var56 * var1.field25092);
            ItemAnimationMath.method00511(var6, field27167 * var22 * var1.field25092, field27168 * var18, field27169, 0.0);
            ItemAnimationMath.method00509(var6, field27170 * var18 * var22 * var1.field25092, field27171 * var18, field27172, 0.0);
            ItemAnimationMath.method00511(var6, field27173 * var22 * var1.field25092, field27174 * var18, field27175, 0.0);
            ItemAnimationMath.method00511(var6, field27176 * var58 * var1.field25092, field27177 * var18, field27178, 0.0);
            ItemAnimationMath.method00511(var6, field27179 * var20 * var1.field25092, field27180 * var18, field27181, 0.0);
            ItemAnimationMath.method00511(var6, field27182 * var26 * var1.field25092, field27183 * var18, field27184, 0.0);
            ItemAnimationMath.method00511(var6, field27185 * var28 * var1.field25092, field27186 * var18, field27187, 0.0);
            ItemAnimationMath.method00511(var6, field27188 * var56 * var1.field25092, field27189 * var18, field27190, 0.0);
         } else {
            if (var3.equals(field27191)) {
               ItemAnimationMath.method00527(var6, field27192 * var22 * var1.field25097);
               ItemAnimationMath.method00517(var6, field27193 * var22 * var1.field25097);
            } else {
               ItemAnimationMath.method00527(var6, 0.0 * var22 * var1.field25097);
               ItemAnimationMath.method00517(var6, field27194 * var22 * var1.field25097);
            }

            ItemAnimationMath.method00529(var6, field27195 * var18 * var22 * var1.field25097);
            if (var3.equals(field27196)) {
               ItemAnimationMath.method00517(var6, field27197 * var28 * var1.field25097);
            } else {
               ItemAnimationMath.method00517(var6, field27198 * var28 * var1.field25097);
               ItemAnimationMath.method00517(var6, field27199 * AnimationCurveMath.method08363(var24) * var1.field25097);
            }

            ItemAnimationMath.method00517(var6, field27200 * var56 * var1.field25097);
            ItemAnimationMath.method00527(var6, field27201 * var56 * var1.field25097);
            ItemAnimationMath.method00529(var6, field27202 * var18 * var26 * var1.field25097);
            ItemAnimationMath.method00529(var6, field27203 * var18 * var56 * var1.field25097);
            ItemAnimationMath.method00529(var6, field27204 * var18 * var28 * var1.field25097);
            if (var3.equals(field27205)) {
               ItemAnimationMath.method00524(var6, field27206 * var22 * var18 * var1.field25097);
            } else {
               ItemAnimationMath.method00524(var6, field27207 * var22 * var18 * var1.field25097);
               ItemAnimationMath.method00512(var6, field27208 * var22 * var18 * var1.field25097);
            }

            ItemAnimationMath.method00524(var6, field27209 * var56 * var18 * var1.field25097);
            ItemAnimationMath.method00513(var6, field27210 * var22 * var1.field25097);
            ItemAnimationMath.method00513(var6, field27211 * var28 * var1.field25097);
            ItemAnimationMath.method00513(var6, field27212 * var26 * var1.field25097);
            ItemAnimationMath.method00513(var6, field27213 * var56 * var1.field25097);
            ItemAnimationMath.method00513(var6, field27214 * var56 * var1.field25097);
            ItemAnimationMath.method00513(var6, field27215 * var58 * var1.field25097);
            ItemAnimationMath.method00524(
               var6,
               ItemAnimationMath.method00520(field27216 * var18 * ItemAnimationMath.method00526(var1.field25064 * field27217) * var24, 0.0, field27218)
                  * var1.field25097
            );
            ItemAnimationMath.method00527(var6, field27219 * ItemAnimationMath.method00526(var1.field25064 * field27220) * var24 * var1.field25097);
         }

         if (var4 && var5 == var0.field19841 && var3.equals(field27339)) {
            if (var0.field19842) {
               ItemAnimationMath.method00529(
                  var6,
                  0.0
                     - field27340
                        * (
                           ItemAnimationMath.method00526(var0.field19846 * var0.field19846 * var0.field19846)
                              + field27341 * ItemAnimationMath.method00526(var1.field25015 * var1.field25015 * var1.field25015 * field27342)
                        )
                        * var18
                        * var1.field25038
                        * var1.field25104
               );
               ItemAnimationMath.method00509(
                  var6,
                  field27343
                     * var18
                     * (
                        ItemAnimationMath.method00526(var0.field19846 * var0.field19846 * var0.field19846)
                           + field27344 * ItemAnimationMath.method00526(var1.field25015 * var1.field25015 * var1.field25015 * field27345)
                     )
                     * var1.field25038
                     * var1.field25104,
                  field27346 * var18,
                  field27347,
                  0.0
               );
            } else {
               ItemAnimationMath.method00529(
                  var6,
                  0.0
                     - field27348
                        * (
                           ItemAnimationMath.method00526(var0.field19846 * var0.field19846 * var0.field19846)
                              + field27349 * ItemAnimationMath.method00526(var1.field25015 * var1.field25015 * var1.field25015 * field27350)
                        )
                        * var18
                        * var1.field25039
                        * var1.field25104
               );
               ItemAnimationMath.method00509(
                  var6,
                  field27351
                     * var18
                     * (
                        ItemAnimationMath.method00526(var0.field19846 * var0.field19846 * var0.field19846)
                           + field27352 * ItemAnimationMath.method00526(var1.field25015 * var1.field25015 * var1.field25015 * field27353)
                     )
                     * var1.field25039
                     * var1.field25104,
                  field27354 * var18,
                  field27355,
                  0.0
               );
            }
         }

         if (var3.equals(field27356) && var1.field25049 + var1.field25051 == 0.0) {
            ItemAnimationMath.method00517(
               var6, 0.0 + field27357 * ItemAnimationMath.method00526(var0.field19846 * var0.field19846 * var0.field19846) * var1.field25099
            );
            ItemAnimationMath.method00511(
               var6,
               field27358 * ItemAnimationMath.method00526(var0.field19846 * var0.field19846 * var0.field19846) * var1.field25099,
               field27359 * var18,
               field27360,
               0.0
            );
         } else if (var1.field25053 == 0.0 && !var3.equals(field27361) && !var3.equals(field27362) && var1.field25036 == 0.0 && var1.field25032 == 0.0) {
            ItemAnimationMath.method00517(var6, 0.0 - field27363 * ItemAnimationMath.method00526(var0.field19846 * var0.field19846 * var0.field19846));
            ItemAnimationMath.method00511(
               var6, field27364 * ItemAnimationMath.method00526(var0.field19846 * var0.field19846 * var0.field19846), field27365 * var18, field27366, 0.0
            );
            if (var15) {
               ItemAnimationMath.method00517(var6, 0.0 - field27367 * ItemAnimationMath.method00526(var0.field19846 * var0.field19846 * var0.field19846));
               ItemAnimationMath.method00524(var6, field27368 * var18 * ItemAnimationMath.method00526(var0.field19846 * var0.field19846 * var0.field19846));
               ItemAnimationMath.method00511(
                  var6, field27369 * ItemAnimationMath.method00526(var0.field19846 * var0.field19846 * var0.field19846), field27370 * var18, field27371, 0.0
               );
            }

            if (!var11) {
               ItemAnimationMath.method00513(var6, var1.field25019 * field27372 * var24);
            }
         }

         double var62 = 0.0;
         if (PlayerAnimationUtils.method09053(var2) != 0.0) {
            var62 = field27373 / PlayerAnimationUtils.method09053(var2) / field27374;
         } else {
            var62 = 1.0;
         }

         if (var62 > 1.0) {
            var62 = 1.0;
         }

         if (var62 < 0.0) {
            var62 = 1.0;
         }

         double var64 = ItemFeatureProperties.method05408(var0.field19838) ? field27375 : 1.0;
         ItemAnimationMath.method00517(var6, field27376 * var1.field25046 * var1.field25108);
         ItemAnimationMath.method00527(
            var6, field27377 * ItemAnimationMath.method00525(var1.field25047) * var18 * var62 * var1.field25046 * var64 * var1.field25108
         );
         ItemAnimationMath.method00513(
            var6, field27378 * var18 * ItemAnimationMath.method00526(var1.field25047) * var62 * var1.field25046 * var64 * var1.field25108
         );
         ItemAnimationMath.method00513(var6, PlayerAnimationUtils.method09053(var2) * var1.field25046 * var1.field25108);
         ItemAnimationMath.method00517(var6, field27379 * PlayerAnimationUtils.method09053(var2) * var1.field25046 * var1.field25108);
         ItemAnimationMath.method00527(var6, field27380 * PlayerAnimationUtils.method09053(var2) * var1.field25046 * var1.field25108);
         ItemAnimationMath.method00529(var6, field27381 * var18 * PlayerAnimationUtils.method09053(var2) * var1.field25046 * var1.field25108);
         if (!var10) {
            ItemAnimationMath.method00529(var6, field27382 * var18 * var1.field25046 * var1.field25108);
            ItemAnimationMath.method00517(var6, field27383 * var1.field25046 * var1.field25108);
            ItemAnimationMath.method00527(var6, field27384 * var1.field25046 * var1.field25108);
         }

         ItemAnimationMath.method00517(var6, field27385 * var1.field25023 * var1.field25107);
         ItemAnimationMath.method00517(
            var6, field27386 * var18 * ItemAnimationMath.method00526(var1.field25059) * var1.field25023 * var62 * var64 * var1.field25024 * var1.field25107
         );
         ItemAnimationMath.method00512(
            var6, field27387 * ItemAnimationMath.method00526(var1.field25059) * var1.field25023 * var64 * var1.field25024 * var1.field25107
         );
         ItemAnimationMath.method00513(
            var6,
            ItemAnimationMath.method00520(
                  field27388 * var18 * ItemAnimationMath.method00525(var1.field25059) * var1.field25023 * var64 * var1.field25024, 0.0, field27389
               )
               * var1.field25107
         );
         if (var10) {
            ItemAnimationMath.method00527(var6, field27390 * var1.field25023 * var1.field25107);
            ItemAnimationMath.method00517(var6, field27391 * var1.field25023 * var1.field25107);
            ItemAnimationMath.method00513(var6, field27392 * var1.field25023 * var1.field25107);
            ItemAnimationMath.method00509(
               var6,
               ItemAnimationMath.method00520(
                     field27393 * ItemAnimationMath.method00526(var1.field25059) * var1.field25023 * var64 * var1.field25024, 0.0, field27394
                  )
                  * var1.field25107,
               field27395,
               field27396,
               0.0
            );
         }

         ItemAnimationMath.method00513(var6, PlayerAnimationUtils.method09053(var2) * var1.field25023 * var1.field25107);
         ItemAnimationMath.method00513(var6, field27397 * var1.field25023 * var1.field25107);
         ItemAnimationMath.method00517(var6, field27398 * PlayerAnimationUtils.method09053(var2) * var1.field25023 * var1.field25107);
         if (var10) {
            ItemAnimationMath.method00517(var6, field27399 * PlayerAnimationUtils.method09053(var2) * var1.field25023 * var1.field25107);
         }

         ItemAnimationMath.method00527(var6, field27400 * PlayerAnimationUtils.method09053(var2) * var1.field25023 * var1.field25107);
         ItemAnimationMath.method00529(var6, field27401 * var18 * PlayerAnimationUtils.method09053(var2) * var1.field25023 * var1.field25107);
         if (!var10) {
            ItemAnimationMath.method00529(var6, field27402 * var18 * var1.field25023 * var1.field25107);
            ItemAnimationMath.method00517(var6, field27403 * var1.field25023 * var1.field25107);
            ItemAnimationMath.method00527(var6, field27404 * var1.field25023 * var1.field25107);
         }

         double var66 = AnimationCurveMath.method08367(var1.field25030) * var1.field25098;
         double var68 = AnimationCurveMath.method08367(var1.field25028) * var1.field25098;
         if (var1.field25030 > 0.0) {
            var1.field25048 = var66 == 1.0 ? field27405 : 1.0 - var66;
         }

         if (var3.equals(field27406) && var0.field19842) {
            ItemAnimationMath.method00529(var6, field27407 * var18);
            ItemAnimationMath.method00517(var6, field27408);
            ItemAnimationMath.method00529(var6, field27409 * var18 * var66);
            ItemAnimationMath.method00517(var6, field27410 * var66);
            ItemAnimationMath.method00517(var6, field27411 * var66);
            ItemAnimationMath.method00529(var6, field27412 * var18 * var66);
            ItemAnimationMath.method00527(var6, field27413 * var66);
            ItemAnimationMath.method00511(var6, field27414 * ItemAnimationMath.method00526(var66 * field27415), field27416 * var18, field27417, 0.0);
            ItemAnimationMath.method00508(var6, field27418 * var18, field27419 * var18, field27420, 0.0);
            ItemAnimationMath.method00508(var6, 0.0 * var18 * var66, field27421 * var18, field27422, 0.0);
            ItemAnimationMath.method00517(var6, field27423 * ItemAnimationMath.method00526(var1.field25026 * field27424) * var1.field25031);
         }

         if (var3.equals(field27425) && !var0.field19842) {
            ItemAnimationMath.method00529(var6, field27426 * var18);
            ItemAnimationMath.method00517(var6, field27427);
            ItemAnimationMath.method00529(var6, field27428 * var18 * var68);
            ItemAnimationMath.method00517(var6, field27429 * var68);
            ItemAnimationMath.method00517(var6, field27430 * var68);
            ItemAnimationMath.method00529(var6, field27431 * var18 * var68);
            ItemAnimationMath.method00527(var6, field27432 * var68);
            ItemAnimationMath.method00511(var6, field27433 * ItemAnimationMath.method00526(var68 * field27434), field27435 * var18, field27436, 0.0);
            ItemAnimationMath.method00508(var6, field27437 * var18, field27438 * var18, field27439, 0.0);
            ItemAnimationMath.method00508(var6, 0.0 * var18 * var68, field27440 * var18, field27441, 0.0);
            ItemAnimationMath.method00517(var6, field27442 * ItemAnimationMath.method00526(var1.field25027 * field27443) * var1.field25029);
         }

         if (!var0.field19842 && var4 || !var0.field19842 && var10) {
            double var70 = AnimationCurveMath.method08375(var1.field25031) * var1.field25098;
            ItemAnimationMath.method00529(var6, (-var34 - var34 / field27444) * var18 * var66);
            ItemAnimationMath.method00529(var6, field27445 * var18 * var66);
            if (!var10) {
               ItemAnimationMath.method00527(var6, ItemAnimationMath.method00526(var66 * field27446 + field27447));
            }

            ItemAnimationMath.method00517(var6, field27448 * var66);
            ItemAnimationMath.method00511(var6, field27449 * ItemAnimationMath.method00526(var66 * field27450) * var18, field27451 * var18, field27452, 0.0);
            ItemAnimationMath.method00508(var6, field27453 * var66 * var18, field27454 * var18, field27455, 0.0);
            ItemAnimationMath.method00508(var6, field27456 * var70 * var18, field27457 * var18, field27458, 0.0);
            ItemAnimationMath.method00512(var6, field27459 * var18 * ItemAnimationMath.method00526(var1.field25026 * field27460) * var70);
            ItemAnimationMath.method00508(var6, field27461 * var66 * var18, field27462 * var18, field27463, 0.0);
            ItemAnimationMath.method00527(var6, field27464 * ItemAnimationMath.method00526(var66 * field27465));
         }

         if (var0.field19842 && var4 || var0.field19842 && var10) {
            double var111 = AnimationCurveMath.method08375(var1.field25029);
            ItemAnimationMath.method00529(var6, (-var34 - var34 / field27466) * var18 * var68);
            ItemAnimationMath.method00529(var6, field27467 * var18 * var68);
            if (!var10) {
               ItemAnimationMath.method00527(var6, ItemAnimationMath.method00526(var68 * field27468 + field27469));
            }

            ItemAnimationMath.method00517(var6, field27470 * var68);
            ItemAnimationMath.method00511(var6, field27471 * ItemAnimationMath.method00526(var68 * field27472) * var18, field27473 * var18, field27474, 0.0);
            ItemAnimationMath.method00508(var6, field27475 * var68 * var18, field27476 * var18, field27477, 0.0);
            ItemAnimationMath.method00508(var6, field27478 * var111 * var18, field27479 * var18, field27480, 0.0);
            ItemAnimationMath.method00512(var6, field27481 * var18 * ItemAnimationMath.method00526(var1.field25027 * field27482) * var111);
            ItemAnimationMath.method00508(var6, field27483 * var68 * var18, field27484 * var18, field27485, 0.0);
            ItemAnimationMath.method00527(var6, field27486 * ItemAnimationMath.method00526(var68 * field27487));
         }

         double var112 = AnimationCurveMath.method08375(var1.field25049) * var1.field25099;
         double var72 = AnimationCurveMath.method08375(var1.field25050) * var1.field25099;
         double var74 = AnimationCurveMath.method08375(var1.field25051) * var1.field25099;
         double var76 = AnimationCurveMath.method08375(var1.field25052) * var1.field25099;
         if (var3.equals(field27488) && var0.field19842) {
            ItemAnimationMath.method00527(var6, field27489 * var112);
            ItemAnimationMath.method00517(var6, field27490 * var112);
            ItemAnimationMath.method00509(var6, field27491 * var18 * var112, field27492 * var18, field27493, 0.0);
            ItemAnimationMath.method00508(var6, field27494 * var18 * var112, field27495 * var18, field27496, 0.0);
         }

         if (!var0.field19842 && var4 || !var0.field19842 && var10) {
            ItemAnimationMath.method00529(var6, (-var34 - var34 / field27497) * var18 * var112);
            ItemAnimationMath.method00529(var6, field27498 * var18 * var112);
            ItemAnimationMath.method00517(var6, field27499 * var112);
            ItemAnimationMath.method00527(var6, field27500 * var112);
            if (!var10) {
               ItemAnimationMath.method00527(var6, ItemAnimationMath.method00526(var112 * field27501 + field27502));
            }

            ItemAnimationMath.method00509(var6, field27503 * var18 * var112, field27504 * var18, field27505, 0.0);
            ItemAnimationMath.method00508(var6, field27506 * var18 * var112, field27507 * var18, field27508, 0.0);
            ItemAnimationMath.method00508(var6, field27509 * var18 * var72, field27510 * var18, field27511, 0.0);
            ItemAnimationMath.method00511(var6, field27512 * var72, field27513 * var18, field27514, 0.0);
         }

         if (var3.equals(field27515) && !var0.field19842) {
            ItemAnimationMath.method00527(var6, field27516 * var74);
            ItemAnimationMath.method00517(var6, field27517 * var74);
            ItemAnimationMath.method00509(var6, field27518 * var18 * var74, field27519 * var18, field27520, 0.0);
            ItemAnimationMath.method00508(var6, field27521 * var18 * var74, field27522 * var18, field27523, 0.0);
         }

         if (var0.field19842 && var4 || var0.field19842 && var10) {
            ItemAnimationMath.method00529(var6, (-var34 - var34 / field27524) * var18 * var74);
            ItemAnimationMath.method00529(var6, field27525 * var18 * var74);
            ItemAnimationMath.method00517(var6, field27526 * var74);
            ItemAnimationMath.method00527(var6, field27527 * var74);
            if (!var10) {
               ItemAnimationMath.method00527(var6, ItemAnimationMath.method00526(var74 * field27528 + field27529));
            }

            ItemAnimationMath.method00509(var6, field27530 * var18 * var74, field27531 * var18, field27532, 0.0);
            ItemAnimationMath.method00508(var6, field27533 * var18 * var74, field27534 * var18, field27535, 0.0);
            ItemAnimationMath.method00508(var6, field27536 * var18 * var76, field27537 * var18, field27538, 0.0);
            ItemAnimationMath.method00511(var6, field27539 * var74, field27540 * var18, field27541, 0.0);
         }

         if (var0.field19842) {
            var1.field25053 = var1.field25053 * var1.field25109;
            var1.field25055 = var1.field25055 * var1.field25109;
            var1.field25056 = var1.field25056 * var1.field25109;
            var1.field25054 = var1.field25054 * var1.field25109;
            double var78 = var1.field25053 * var1.field25053;
            if ((var3.equals(field27542) || var3.equals(field27543)) && var0.field19842) {
               ItemAnimationMath.method00517(var6, field27544 * var78);
               ItemAnimationMath.method00529(var6, field27545 * var18 * var78);
               ItemAnimationMath.method00527(var6, field27546 * var78);
               ItemAnimationMath.method00527(var6, 0.0 * var1.field25057);
               ItemAnimationMath.method00513(var6, field27547 * var78);
               ItemAnimationMath.method00513(var6, field27548 * var1.field25057);
               if (var3.equals(field27549)) {
                  ItemAnimationMath.method00513(
                     var6,
                     field27550
                        * AnimationCurveMath.method08367(ItemAnimationMath.method00514(ItemAnimationMath.method00526(var1.field25054 * field27551)))
                        * var78
                  );
                  ItemAnimationMath.method00512(
                     var6,
                     field27552
                        * var18
                        * AnimationCurveMath.method08367(ItemAnimationMath.method00514(ItemAnimationMath.method00526(var1.field25054 * field27553)))
                        * var78
                  );
                  ItemAnimationMath.method00524(
                     var6,
                     field27554
                        * var18
                        * AnimationCurveMath.method08367(ItemAnimationMath.method00514(ItemAnimationMath.method00526(var1.field25054 * field27555)))
                        * var78
                  );
               } else {
                  ItemAnimationMath.method00513(
                     var6, field27556 * AnimationCurveMath.method08361(ItemAnimationMath.method00526(var1.field25054 * field27557)) * var78
                  );
                  ItemAnimationMath.method00512(
                     var6, field27558 * var18 * AnimationCurveMath.method08361(ItemAnimationMath.method00526(var1.field25054)) * var78
                  );
                  ItemAnimationMath.method00524(
                     var6, field27559 * var18 * AnimationCurveMath.method08361(ItemAnimationMath.method00526(var1.field25054)) * var78
                  );
               }

               ItemAnimationMath.method00508(var6, field27560 * var78 * var18, field27561 * var18, field27562, 0.0);
               ItemAnimationMath.method00511(var6, field27563 * ItemAnimationMath.method00526(var78 * field27564), field27565 * var18, field27566, 0.0);
            }

            if ((var3.equals(field27567) || var10 || ItemFeatureProperties.method05404(var0.field19838, Items.GLASS_BOTTLE)) && var0.field19842) {
               ItemAnimationMath.method00517(var6, field27568 * var78);
               ItemAnimationMath.method00529(var6, field27569 * var18 * var78);
               ItemAnimationMath.method00527(var6, field27570 * var78);
               ItemAnimationMath.method00527(var6, 0.0 * var1.field25057);
               ItemAnimationMath.method00513(var6, field27571 * var78);
               ItemAnimationMath.method00513(var6, field27572 * var1.field25057);
               ItemAnimationMath.method00513(var6, field27573 * ItemAnimationMath.method00526(var1.field25054 * field27574) * var1.field25057);
               ItemAnimationMath.method00508(var6, var18 * field27575 * var78, field27576 * var18, field27577, 0.0);
               ItemAnimationMath.method00511(var6, field27578 * ItemAnimationMath.method00526(var78 * field27579), field27580 * var18, field27581, 0.0);
            }
         } else {
            double var113 = var1.field25055 * var1.field25055;
            if ((var3.equals(field27582) || var3.equals(field27583)) && !var0.field19842) {
               ItemAnimationMath.method00517(var6, field27584 * var113);
               ItemAnimationMath.method00529(var6, field27585 * var18 * var113);
               ItemAnimationMath.method00527(var6, field27586 * var113);
               ItemAnimationMath.method00527(var6, 0.0 * var1.field25058);
               ItemAnimationMath.method00513(var6, field27587 * var113);
               ItemAnimationMath.method00513(var6, field27588 * var1.field25058);
               if (var3.equals(field27589)) {
                  ItemAnimationMath.method00513(
                     var6,
                     field27590
                        * AnimationCurveMath.method08367(ItemAnimationMath.method00514(ItemAnimationMath.method00526(var1.field25056 * field27591)))
                        * var113
                  );
                  ItemAnimationMath.method00512(
                     var6,
                     field27592
                        * var18
                        * AnimationCurveMath.method08367(ItemAnimationMath.method00514(ItemAnimationMath.method00526(var1.field25056 * field27593)))
                        * var113
                  );
                  ItemAnimationMath.method00524(
                     var6,
                     field27594
                        * var18
                        * AnimationCurveMath.method08367(ItemAnimationMath.method00514(ItemAnimationMath.method00526(var1.field25056 * field27595)))
                        * var113
                  );
               } else {
                  ItemAnimationMath.method00513(
                     var6, field27596 * AnimationCurveMath.method08361(ItemAnimationMath.method00526(var1.field25056 * field27597)) * var113
                  );
                  ItemAnimationMath.method00512(
                     var6, field27598 * var18 * AnimationCurveMath.method08361(ItemAnimationMath.method00526(var1.field25056)) * var113
                  );
                  ItemAnimationMath.method00524(
                     var6, field27599 * var18 * AnimationCurveMath.method08361(ItemAnimationMath.method00526(var1.field25056)) * var113
                  );
               }

               ItemAnimationMath.method00508(var6, field27600 * var18 * var113, field27601 * var18, field27602, 0.0);
               ItemAnimationMath.method00511(var6, field27603 * ItemAnimationMath.method00526(var113 * field27604), field27605 * var18, field27606, 0.0);
            }

            if (var3.equals(field27607) && !var0.field19842) {
               ItemAnimationMath.method00517(var6, field27608 * var113);
               ItemAnimationMath.method00529(var6, field27609 * var18 * var113);
               ItemAnimationMath.method00527(var6, field27610 * var113);
               ItemAnimationMath.method00527(var6, 0.0 * var1.field25058);
               ItemAnimationMath.method00513(var6, field27611 * var113);
               ItemAnimationMath.method00513(var6, field27612 * var1.field25058);
               ItemAnimationMath.method00513(var6, field27613 * ItemAnimationMath.method00526(var1.field25056 * field27614) * var1.field25058);
               ItemAnimationMath.method00508(var6, field27615 * var18 * var113, field27616 * var18, field27617, 0.0);
               ItemAnimationMath.method00511(var6, field27618 * ItemAnimationMath.method00526(var113 * field27619), field27620 * var18, field27621, 0.0);
            }
         }

         double var114 = AnimationCurveMath.method08367(var1.field25021);
         double var80 = AnimationCurveMath.method08367(var1.field25022);
         if (var3.equals(field27622) && var0.field19842) {
            ItemAnimationMath.method00517(var6, field27623 * var114);
            ItemAnimationMath.method00529(var6, field27624 * var18 * var114);
            ItemAnimationMath.method00527(var6, field27625 * var114);
            ItemAnimationMath.method00529(var6, field27626 * var18 * ItemAnimationMath.method00526(var1.field25054 * field27627) * var114);
            ItemAnimationMath.method00527(var6, field27628 * ItemAnimationMath.method00526(var1.field25054 * field27629) * var114);
            ItemAnimationMath.method00513(var6, field27630 * ItemAnimationMath.method00526(var114 * field27631));
            ItemAnimationMath.method00512(var6, field27632 * var18 * var114);
            ItemAnimationMath.method00512(var6, field27633 * var18 * ItemAnimationMath.method00526(var1.field25054 * field27634) * var114);
            ItemAnimationMath.method00524(var6, field27635 * var18 * var114);
            ItemAnimationMath.method00524(var6, field27636 * var18 * ItemAnimationMath.method00526(var1.field25054 * field27637) * var114);
         }

         if (var3.equals(field27638) && !var0.field19842) {
            ItemAnimationMath.method00517(var6, field27639 * var80);
            ItemAnimationMath.method00529(var6, field27640 * var18 * var80);
            ItemAnimationMath.method00527(var6, field27641 * var80);
            ItemAnimationMath.method00529(var6, field27642 * var18 * ItemAnimationMath.method00526(var1.field25056 * field27643) * var80);
            ItemAnimationMath.method00527(var6, field27644 * ItemAnimationMath.method00526(var1.field25056 * field27645) * var80);
            ItemAnimationMath.method00513(var6, field27646 * ItemAnimationMath.method00526(var80 * field27647));
            ItemAnimationMath.method00512(var6, field27648 * var18 * var80);
            ItemAnimationMath.method00512(var6, field27649 * var18 * ItemAnimationMath.method00526(var1.field25056 * field27650) * var80);
            ItemAnimationMath.method00524(var6, field27651 * var18 * var80);
            ItemAnimationMath.method00524(var6, field27652 * var18 * ItemAnimationMath.method00526(var1.field25056 * field27653) * var80);
         }

         if (ItemFeatureProperties.method05420(var0.field19838, ItemTagAliases.field23900)) {
            ItemAnimationMath.method00529(var6, field27654 * var18);
            ItemAnimationMath.method00511(var6, field27655, field27656 * var18, field27657, 0.0);
            ItemAnimationMath.method00508(var6, field27658 * var18, field27659 * var18, field27660, 0.0);
         }

         if (PlayerAnimationUtils.method09045(var0.field19838, var2) && var3.equals(field27661)) {
            var1.field25015 = var1.field25015 + field27662 * var0.field19847 * field27663;
         } else if (var3.equals(field27664)) {
            var1.field25015 = var1.field25015 - field27665 * var0.field19847 * field27666;
         }

         var1.field25015 = ItemAnimationMath.method00520(var1.field25015, 0.0, 1.0);
         double var82 = var1.field25015 * var1.field25015;
         if (var3.equals(field27667)) {
            ItemAnimationMath.method00517(var6, field27668 * var82);
            ItemAnimationMath.method00527(var6, field27669 * var82);
            ItemAnimationMath.method00529(var6, field27670 * var18 * var82);
            ItemAnimationMath.method00513(var6, field27671 * var82);
            ItemAnimationMath.method00513(var6, field27672 * ItemAnimationMath.method00526(var82 * field27673));
            ItemAnimationMath.method00512(var6, field27674 * var18 * var82);
            ItemAnimationMath.method00524(var6, field27675 * var18 * var82);
         }

         var1.field25000 = var0.field19853;
         double var84 = ItemAnimationMath.method00526(ItemAnimationMath.method00520(var1.field25053, field27676, 1.0) * field27677 * field27678) * field27679;
         var1.field25016 = var1.field25016 + var84 * var0.field19847 * field27680;
         var1.field25016 = var1.field25016 * ItemAnimationMath.method00519(field27681, var0.field19847 * field27682);
         if (var10 && var1.field25057 > 0.0) {
            ItemAnimationMath.method00524(var6, field27683 * var18);
            ItemAnimationMath.method00527(var6, field27684);
         }

         double var86 = AnimationCurveMath.method08367(var1.field25013);
         double var88 = AnimationCurveMath.method08375(var1.field25014);
         if (var16) {
            ItemAnimationMath.method00529(var6, (field27685 - field27686 * var88) * var18 * var86);
            ItemAnimationMath.method00527(var6, field27687 * var86);
            ItemAnimationMath.method00517(var6, field27688 * var88 * var86);
            ItemAnimationMath.method00513(var6, ItemAnimationMath.method00520(PlayerAnimationUtils.method09053(var2), 0.0, field27689) * var86);
            ItemAnimationMath.method00513(var6, field27690 * var86);
            ItemAnimationMath.method00508(var6, (field27691 + field27692 * var88) * var18 * var86, field27693 * var18, field27694, 0.0);
         }

         if (var16) {
            double var90 = 1.0 - var86;
            ItemAnimationMath.method00529(var6, field27695 * var18 * var90);
            ItemAnimationMath.method00527(var6, field27696 * var90);
            ItemAnimationMath.method00517(var6, field27697 * var90);
            ItemAnimationMath.method00513(var6, field27698 * var90);
            ItemAnimationMath.method00512(var6, field27699 * var18 * var90);
         }

         if (var3.equals(field27700)) {
            ItemAnimationMath.method00529(var6, field27701 * var18);
            ItemAnimationMath.method00517(var6, field27702);
            ItemAnimationMath.method00511(var6, field27703, field27704 * var18, field27705, 0.0);
            ItemAnimationMath.method00508(var6, field27706 * var18, field27707 * var18, field27708, 0.0);
         }

         int var115 = var1.field24994 != 0 ? var1.field24994 : 67;
         if (ItemAnimationChecks.method10893(var115)) {
            var1.field25010 = var1.field25010 + field27709 * var0.field19847 * field27710;
         } else {
            var1.field25010 = var1.field25010 - field27711 * var0.field19847 * field27712;
         }

         var1.field25010 = ItemAnimationMath.method00520(var1.field25010, 0.0, 1.0);
         if ((var12 || var13 || var14 || var3.equals(field27713)) && var0.field19842) {
            ItemAnimationMath.method00529(var6, field27714 * var18 * AnimationCurveMath.method08367(var1.field25010));
            ItemAnimationMath.method00517(var6, field27715 * AnimationCurveMath.method08367(var1.field25010));
            ItemAnimationMath.method00508(var6, field27716 * AnimationCurveMath.method08367(var1.field25010) * var18, field27717 * var18, field27718, 0.0);
            ItemAnimationMath.method00511(
               var6,
               field27719 * ItemAnimationMath.method00520(ItemAnimationMath.method00526(var1.field25010 * field27720), 0.0, 1.0),
               field27721 * var18,
               field27722,
               0.0
            );
            ItemAnimationMath.method00513(var6, field27723 * ItemAnimationMath.method00526(AnimationCurveMath.method08367(var1.field25011) * field27724));
         }

         if (var15 && var0.field19842) {
            ItemAnimationMath.method00529(var6, field27725 * var18 * AnimationCurveMath.method08367(var1.field25010));
            ItemAnimationMath.method00517(var6, field27726 * AnimationCurveMath.method08367(var1.field25010));
            ItemAnimationMath.method00508(var6, field27727 * AnimationCurveMath.method08367(var1.field25010) * var18, field27728 * var18, field27729, 0.0);
            ItemAnimationMath.method00511(
               var6,
               field27730 * ItemAnimationMath.method00520(ItemAnimationMath.method00526(var1.field25010 * field27731), 0.0, 1.0),
               field27732 * var18,
               field27733,
               0.0
            );
         }

         if (var0.field19842) {
            var1.field24995 = var17;
         } else {
            var1.field24996 = var17;
         }

         if (PlayerAnimationUtils.method09038(var2) && var3.equals(field27734) && var5 == var0.field19841) {
            if (var0.field19842) {
               var1.field25007 = var1.field25007 + field27735 * var0.field19847 * field27736;
            } else {
               var1.field25008 = var1.field25008 + field27737 * var0.field19847 * field27738;
            }
         } else if (var0.field19842) {
            var1.field25007 = var1.field25007 - field27739 * var0.field19847 * field27740;
         } else {
            var1.field25008 = var1.field25008 - field27741 * var0.field19847 * field27742;
         }

         var1.field25007 = ItemAnimationMath.method00520(var1.field25007, 0.0, 1.0);
         var1.field25008 = ItemAnimationMath.method00520(var1.field25008, 0.0, 1.0);
         var1.field25007 = var1.field25007
            * ItemAnimationMath.method00519(field27743, var0.field19847 * field27744)
            * (1.0 - ItemAnimationMath.method00520(var0.field19845 * field27745, 0.0, 1.0))
            * (1.0 - ItemAnimationMath.method00520(var1.field25036 * field27746, 0.0, 1.0));
         var1.field25008 = var1.field25008
            * ItemAnimationMath.method00519(field27747, var0.field19847 * field27748)
            * (1.0 - ItemAnimationMath.method00520(var0.field19845 * field27749, 0.0, 1.0))
            * ItemAnimationMath.method00520(1.0 - var1.field25032 * field27750, 0.0, 1.0);
         if (var3.equals(field27751)) {
            double var91 = var0.field19842 ? AnimationCurveMath.method08375(var1.field25007) : AnimationCurveMath.method08375(var1.field25008);
            double var93 = var0.field19842
               ? ItemAnimationMath.method00520(var1.field25007 * field27752, 0.0, 1.0)
               : ItemAnimationMath.method00520(var1.field25008 * field27753, 0.0, 1.0);
            ItemAnimationMath.method00517(var6, field27754 * var91 * var93);
            ItemAnimationMath.method00529(var6, field27755 * var18 * var91 * var93);
            ItemAnimationMath.method00527(var6, 0.0 * var91 * var93);
            ItemAnimationMath.method00512(var6, field27756 * var18 * var91 * var93);
            ItemAnimationMath.method00513(
               var6,
               field27757
                  * AnimationCurveMath.method08375(ItemAnimationMath.method00526(var0.field19842 ? var1.field25007 : var1.field25008 * field27758))
                  * var93
            );
            ItemAnimationMath.method00509(
               var6,
               field27759
                  * AnimationCurveMath.method08375(ItemAnimationMath.method00526(var0.field19842 ? var1.field25007 : var1.field25008 * field27760))
                  * var93
                  * var18,
               field27761 * var18,
               field27762,
               0.0
            );
         }

         double var116 = var0.field19842 ? var1.field25065 : var1.field25069;
         double var117 = var0.field19842 ? var1.field25067 : var1.field25070;
         double var95 = var0.field19842 ? var1.field25068 : var1.field25071;
         double var97 = var0.field19842 ? var1.field25060 : var1.field25061;
         double var99 = var0.field19842 ? AnimationCurveMath.method08361(var1.field25072) : var1.field25073;
         if (var3.equals(field27763)) {
            ItemAnimationMath.method00517(var6, field27764);
            ItemAnimationMath.method00527(var6, field27765);
            ItemAnimationMath.method00513(var6, field27766);
            ItemAnimationMath.method00517(var6, field27767 * ItemAnimationMath.method00526(AnimationCurveMath.method08361(var99) * field27768));
            ItemAnimationMath.method00517(var6, field27769 * AnimationCurveMath.method08367(var116));
            ItemAnimationMath.method00517(var6, field27770 * AnimationCurveMath.method08375(var95) * var95);
            ItemAnimationMath.method00512(var6, field27771 * AnimationCurveMath.method08367(var116) * var18);
            ItemAnimationMath.method00511(var6, field27772 * ItemAnimationMath.method00526(var116 * field27773), 0.0, field27774, field27775);
            ItemAnimationMath.method00511(var6, field27776 * AnimationCurveMath.method08367(var117), field27777 * var18, field27778, field27779);
            ItemAnimationMath.method00508(
               var6,
               field27780 * ItemAnimationMath.method00526(var1.field25045 * field27781) * AnimationCurveMath.method08367(var117) * var18,
               field27782 * var18,
               field27783,
               0.0
            );
            ItemAnimationMath.method00511(
               var6,
               field27784 * ItemAnimationMath.method00526(var1.field25045 * field27785) * AnimationCurveMath.method08367(var117),
               field27786 * var18,
               field27787,
               0.0
            );
            ItemAnimationMath.method00513(var6, field27788 * ItemAnimationMath.method00526(var99 * field27789));
            ItemAnimationMath.method00509(var6, field27790 * AnimationCurveMath.method08375(var95) * var95 * var18, field27791 * var18, field27792, field27793);
            ItemAnimationMath.method00509(
               var6,
               field27794
                  * ItemAnimationMath.method00526(ItemAnimationMath.method00520(var97 * field27795, 0.0, 1.0) * field27796)
                  * ItemAnimationMath.method00526(ItemAnimationMath.method00520(var97 * field27797, 0.0, 1.0) * field27798)
                  * var18,
               field27799 * var18,
               field27800,
               0.0
            );
            ItemAnimationMath.method00511(
               var6,
               field27801
                  * ItemAnimationMath.method00526(ItemAnimationMath.method00520(var97 * field27802, 0.0, 1.0) * field27803)
                  * ItemAnimationMath.method00526(ItemAnimationMath.method00520(var97 * field27804, 0.0, 1.0) * field27805),
               field27806 * var18,
               field27807,
               0.0
            );
         }
      }
   }
}
